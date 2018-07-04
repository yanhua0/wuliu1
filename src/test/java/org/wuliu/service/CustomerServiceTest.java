package org.wuliu.service;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Test
    public void findByNameAndPassword() {

    }

    @Test
    public void findByNameAndPassword1() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void findByName() {
        customerService.findByName("1","1","1");
    }

    @Test
    public void update() {
    }

    @Test
    public void findByName1() {
    }
}