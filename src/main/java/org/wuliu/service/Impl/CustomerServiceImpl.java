package org.wuliu.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.CustomerDao;
import org.wuliu.entity.Customer;
import org.wuliu.enums.ResultEnum;
import org.wuliu.service.CustomerService;
import org.wuliu.utils.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Service
public class CustomerServiceImpl implements CustomerService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerDao customerDao;
    @Override
    public Result findByNameAndPassword(String name, String password, HttpSession session, HttpServletResponse response) {
        try{
            Customer customer=customerDao.findByNameAndPassword(name,password);
            if(customer!=null)
            {
                session.setAttribute("customer", customer);
                //存sessionId的cookie
                Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
                cookieSId.setMaxAge(60*60);
                cookieSId.setPath("/");
                response.addCookie(cookieSId);
                logger.info("用户登录成功！！！！");
                return new Result(ResultEnum.SUCCESS);
            }
            else{
                logger.info("登录失败");
                return new Result(ResultEnum.FAIL,"密码错误");
            }

        }catch (Exception e)
        {
            logger.error(e.getMessage());
            return new Result(ResultEnum.FAIL,e.getMessage());
        }
    }

    @Override
    public int insert(String name, String password, String sex, String phone, String email, String question, String result) {
       Customer customer=customerDao.findByName(name);
       if(customer==null)
       {
           int insert=customerDao.insert(name,password,sex,phone,email,question,result,"1");
           logger.info("insert="+insert);
           return insert;
       }
       else{
           logger.warn("用户名重复"+name);
           return 0;
       }
    }

    @Override
    public Result findByName(String name, String qu, String res) {
        Customer customer=customerDao.findByName(name);
        if(customer!=null)
        {
            if(customer.getQuestion().equals(qu)&&customer.getResult().equals(res)){
                return new Result(ResultEnum.SUCCESS);
            }
            else{
                return new Result(ResultEnum.FAIL);
            }
        }
        else {
            logger.error("找回密码失败--用户名未注册！");
            return new Result(ResultEnum.FAIL,"该用户名未注册！");
        }

    }

    @Override
    public int update(String password,String name) {
        int update=customerDao.update(password,name);
        return 0;
    }

    @Override
    public Customer findByName(String name) {
        return customerDao.findByName(name);
    }

}
