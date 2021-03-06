package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.CloseSeckillException;
import org.seckill.exception.RepeatSeckillException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在使用者的角度上设计接口
 * 三个方面：方法定义力度，返回值类型，参数
 *
 * @author AlbertRui
 */
@SuppressWarnings("JavaDoc")
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getSeckillById(Long seckillId);

    /**
     * 秒杀开启时，输出秒杀接口地址
     * 否则输出秒杀时间和系统时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(Long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) throws SeckillException, RepeatSeckillException, CloseSeckillException;

    /**
     * 执行秒杀操作by 存储过程
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckillProdedure(Long seckillId, Long userPhone, String md5);
}
