package org.wuliu.service;

import org.wuliu.entity.Customer;
import org.wuliu.utils.Result;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface CustomerService {
    Result findByNameAndPassword(String name, String password, HttpSession session, HttpServletResponse response);
    int insert(String name,String password,String sex
            ,String phone,String email,String question,String result);
    Result findByName(String name,String qu,String res);
    int update(String password,String name);
    Customer findByName(String name);

}
