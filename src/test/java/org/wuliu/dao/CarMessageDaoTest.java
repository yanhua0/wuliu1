package org.wuliu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CarMessageDaoTest {
    @Autowired
    private CarMessageDao carMessageDao;
    @Test
    public void queryAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void insert() {

    }
}