package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
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
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author AlbertRui
 * @date 2018-03-06 21:35
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private final SuccessKilledDao successKilledDao;

    //MD5盐值字符串，用于混淆md5
    private final String slat = "#$%$@fjkal;fjad;fdjfdas$";
    private final SeckillDao seckillDao;

    //注入service依赖
    @Autowired
    public SeckillServiceImpl(SeckillDao seckillDao, SuccessKilledDao successKilledDao) {
        this.seckillDao = seckillDao;
        this.successKilledDao = successKilledDao;
    }

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    @Override
    public Seckill getSeckillById(long seckillId) {
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
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
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
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatSeckillException, CloseSeckillException {
        if (md5 == null || md5.equals(getMD5(seckillId))) {
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

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
