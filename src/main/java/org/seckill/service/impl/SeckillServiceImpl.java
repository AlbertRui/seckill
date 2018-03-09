package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.CloseSeckillException;
import org.seckill.exception.RepeatSeckillException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author AlbertRui
 * @date 2018-03-06 21:35
 */
@SuppressWarnings("ALL")
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    //MD5盐值字符串，用于混淆md5
    private final String slat = "#$%$@fjkal;fjad;fdjfdas$";

    //注入service依赖

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 5);
    }

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    @Override
    public Seckill getSeckillById(Long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 秒杀开启时，输出秒杀接口地址
     * 否则输出秒杀时间和系统时间
     *
     * @param seckillId
     * @return
     */
    @Override
    public Exposer exportSeckillUrl(Long seckillId) {
        //优化点：缓存优化，一致性维护建立在超时的基础上
        //1.访问redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill == null) {
            //2.访问数据库
            seckill = seckillDao.queryById(seckillId);
            if (seckill == null) {
                return new Exposer(false, seckillId);
            } else {
                //3.放入redis
                redisDao.putSeckill(seckill);
            }
        }

        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();

        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        //转化特定字符串的过程
        String md5 = getMD5(seckillId);
        return new Exposer(true, seckillId, md5);
    }

    /**
     * 执行秒杀操作
     * 使用注解控制事物方法的优点：
     * 1.开发团队达成一致约定，明确标注事物方法的编程风格
     * 2.保证事物方法执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求，或者剥离事物方法外部
     * 3.不是所有的方法都需要事物，如只有一条修改操作，制度操作不需要事物控制
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    @Override
    @Transactional
    public SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) throws SeckillException, RepeatSeckillException, CloseSeckillException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }

        //执行秒杀逻辑，减库存，记录购买行为
        Date nowTime = new Date();

        try {
            //减库存
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount < 0) {
                //没有更新记录，秒杀结束
                throw new CloseSeckillException("seckill is closed");
            } else {
                //记录购买行为
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatSeckillException("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (CloseSeckillException | RepeatSeckillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }

    private String getMD5(Long seckillId) {
        String base = seckillId + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
