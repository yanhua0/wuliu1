package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.CustomerDao;
import org.wuliu.entity.Customer;
import org.wuliu.entity.Placard;
import org.wuliu.enums.ResultEnum;
import org.wuliu.service.CustomerService;
import org.wuliu.utils.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
                logger.info("找回成功!");
                return new Result(ResultEnum.SUCCESS);
            }
            else{
                logger.error("找回失败--答案错误！");
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
        logger.info("修改密码成功！！----"+name);
        return 0;
    }

    @Override
    public Customer findByName(String name) {
        return customerDao.findByName(name);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(int id) {
       return customerDao.findById(id);
    }

    @Override
    public void delete(int id) {
        Customer customer=customerDao.findById(id);
        if(customer!=null)
        {
            customerDao.delete(id);
        }
        logger.error("错误的id="+id);
    }

    @Override
    public Result updateAll(Customer customer,String name,HttpSession session) {
         Customer customer1=findByName(customer.getName());
        Customer customer2=findById(customer.getId());
       Customer customer3= (Customer) session.getAttribute("customer");
         if(customer1==null||customer2.getName().equals(name))
         {
             customerDao.updateAll(customer);
             if(customer.getId()!=customer3.getId())
             {
                 return new Result(ResultEnum.ADMIN);
             }
             return new Result(ResultEnum.SUCCESS);

         }

         logger.error("修改的用户名重复-----------"+customer.getName());
         return  new Result(ResultEnum.FAIL);
    }

    @Override
    public PageInfo<Customer> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<Customer> list=findAll();
        return new PageInfo<Customer>(list);
    }

}
