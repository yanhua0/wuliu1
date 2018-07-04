package org.wuliu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wuliu.entity.Logistics;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LogisticsDaoTest {
    @Autowired
    private LogisticsDao logisticsDao;
    @Test
    public void insert() {
        Logistics logistics=new Logistics("1","1","2");
        logisticsDao.insert(logistics);
    }
}