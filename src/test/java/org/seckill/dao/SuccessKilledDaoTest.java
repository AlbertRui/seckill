package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        int inseertCount = successKilledDao.insertSuccessKilled(1000L, 15790437832L);
        System.out.println(inseertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L, 15790437832L);
        System.out.println(successKilled.getSeckill());
        System.out.println(successKilled.getState());
        System.out.println(successKilled);
    }
}