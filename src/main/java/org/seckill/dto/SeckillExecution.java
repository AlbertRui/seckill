package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后的结果
 *
 * @author AlbertRui
 * @date 2018-03-06 21:09
 */
@SuppressWarnings("ALL")
public class SeckillExecution {

    //秒杀id
    private Long seckillId;

    //秒杀执行结果状态
    private int state;

    //秒杀状态表示
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;

    /**
     * 秒杀成功
     *
     * @param seckillId
     * @param state
     * @param stateInfo
     * @param successKilled
     */
    public SeckillExecution(Long seckillId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    /**
     * 秒杀失败
     *
     * @param seckillId
     * @param state
     * @param stateInfo
     */
    public SeckillExecution(Long seckillId, SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
