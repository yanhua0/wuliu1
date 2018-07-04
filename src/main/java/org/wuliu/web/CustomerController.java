package org.wuliu.web;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wuliu.entity.Customer;
import org.wuliu.service.CustomerService;
import org.wuliu.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class CustomerController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Reg()
    {
        return "register";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam Map<String ,String> map,RedirectAttributes attr)
    {
        int in=customerService.insert(map.get("name"),map.get("password"),map.get("sex"),map.get("phone"),map.get("email"),map.get("question"),map.get("result"));
        if(in==0)
        {
            attr.addFlashAttribute("error","该用户名已被注册！");
           return "redirect:/register";
        }
        logger.info("新增用户"+map.get("name"));
        return "redirect:/index";
    }
    @RequestMapping(value = "/found",method = RequestMethod.GET)
    public String found(Model model, HttpSession session){
        Customer customer= (Customer) session.getAttribute("customer");

        return "found";}
    @RequestMapping(value = "/foundPassword",method = RequestMethod.POST)
    public String found2(@RequestParam Map<String,String> map,RedirectAttributes attr,HttpSession session) {
        Result result = customerService.findByName(map.get("name"), map.get("question"), map.get("result"));
        if (result.getCode() == 0) {
            logger.info("找回成功"+map.get("name"));
            session.setAttribute("name",map.get("name"));
            return "reset";
        } else {
            attr.addFlashAttribute("error","用户名或答案错误！");
            return "redirect:/found";
        }

    }
    @RequestMapping(value = "/findpro",method = RequestMethod.POST)
    @ResponseBody
    public Customer fou(@RequestParam("name")String name)
    {
        return customerService.findByName(name);
    }
    @RequestMapping(value = "/changepassword",method = RequestMethod.POST)
    public String found3(@RequestParam Map<String,String> map, HttpSession session) {
        String name= (String) session.getAttribute("name");
        int u=customerService.update(map.get("password"),name);
        session.invalidate();
        return "redirect:/index";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String log(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index";
    }

}
