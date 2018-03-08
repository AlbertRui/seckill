package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getSeckillById() {
        Seckill seckill = seckillService.getSeckillById(1000);
        logger.info("seckill={}", seckill);
    }

    /**
     * 测试代码完整逻辑
     * 注意：可重复执行
     */
    @Test
    public void testSeckillLogic() {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            try {
                SeckillExecution execution = seckillService.executeSeckill(1000, 15790437832L, exposer.getMd5());
                logger.info("execution={}", execution);
            } catch (SeckillException ignore) {
            }
        } else {
            //秒杀未开启
            logger.warn("exposer={}", exposer);
        }
    }

    @Test
    public void executeSeckill() {
        try {
            SeckillExecution execution = seckillService.executeSeckill(1000, 15790437832L, "1984e2360eed75048c89adf8cf82d5f8");
            logger.info("execution={}", execution);
        } catch (SeckillException ignore) {
        }
    }
}