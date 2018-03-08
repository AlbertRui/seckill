package org.seckill.dto;

/**
 * 数据传输层：暴露秒杀地址dto
 *
 * @author AlbertRui
 * @date 2018-03-06 20:57
 */
public class Exposer {

    //是否开启秒杀
    private boolean exposed;

    //秒杀id
    private Long seckillId;

    //使用md5加密
    private String md5;

    //系统当前时间（毫秒）
    private Long now;

    //秒杀开启时间
    private Long start;

    //秒杀结束时间
    private Long end;

    public Exposer(boolean exposed, Long seckillId, String md5) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.md5 = md5;
    }

    public Exposer(boolean exposed, Long seckillId, Long now, Long start, Long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, Long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", seckillId=" + seckillId +
                ", md5='" + md5 + '\'' +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
