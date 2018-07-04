package org.wuliu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wuliu.entity.Customer;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CustomerDaoTest {
   @Autowired
   private  CustomerDao customerDao;
    @Test
    public void findByNameAndPassword() {

        Customer customer=new Customer();
        customer.setPassword("1");
        customer.setName("1");

    }
}