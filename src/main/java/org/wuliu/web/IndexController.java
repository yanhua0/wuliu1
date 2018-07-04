package org.wuliu.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.wuliu.entity.CarMessage;

import org.wuliu.entity.Enterprise;
import org.wuliu.entity.GoodsMeg;
import org.wuliu.service.CarMessageService;
import org.wuliu.service.CustomerService;
import org.wuliu.service.EnterpriseService;
import org.wuliu.service.GoodsMegService;
import org.wuliu.utils.Result;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GoodsMegService goodsMegService;
    @Autowired
    private CarMessageService carMessageService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Index(Model model)
    {
        List<GoodsMeg> goodsMeg=goodsMegService.queryAll();
        List<CarMessage> carMessage=carMessageService.queryAll();
        List<Enterprise> enterprise=enterpriseService.queryAll();
        model.addAttribute("goodsMeg",goodsMeg);
        model.addAttribute("carMessage",carMessage);
        model.addAttribute("enterprise",enterprise);
        return "index";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(RedirectAttributes attr, @RequestParam Map<String ,String> map, HttpSession session, HttpServletResponse response)
    {   String name=null;
        String password=null;
        System.out.println(map);
        if(map.containsKey("name"))
        {
            name=map.get("name");
        }
        if(map.containsKey("password"))
        {
            password=map.get("password");
        }
       Result result=customerService.findByNameAndPassword(name,password,session,response);
        if(result.getCode()==0)
        {
             return "redirect:/index";
        }
        else{
            attr.addFlashAttribute("error","账号或密码错误！");
            return "redirect:/index";
        }
    }
}
