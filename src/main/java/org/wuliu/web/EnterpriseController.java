package org.wuliu.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuliu.entity.CarMessage;
import org.wuliu.entity.Customer;
import org.wuliu.entity.Enterprise;
import org.wuliu.service.CarMessageService;
import org.wuliu.service.EnterpriseService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @RequestMapping(value = "/enterprise_select",method = RequestMethod.GET)
    public String CarMessage(Model model, @RequestParam(value = "page",defaultValue = "1",required = true) Integer page)
    {
        PageInfo<Enterprise> p=enterpriseService.findpage(page);
        model.addAttribute("page",p);
        return "enterprise_select";
    }
    @RequestMapping(value = "/enterprise_add",method = RequestMethod.GET)
    public String add2(){return "enterprise_add";}
    @RequestMapping(value = "/add3",method = RequestMethod.POST)
    public String add3(@RequestParam Map<String,String> map, HttpSession session)
    { Customer customer= (Customer) session.getAttribute("customer");
        int in=enterpriseService.insert(map.get("style"),map.get("name"),map.get("operation")
     ,map.get("area"),map.get("address"),map.get("phone"),map.get("linkman"),map.get("hand"),
            map.get("fax"),map.get("email"),map.get("web"),map.get("intr"),customer.getName());
        System.out.println(map);
      return "redirect:/enterprise_select";
    }
    @RequestMapping(value = "/enterprise_show",method = RequestMethod.GET)
    public String show(Model model,@RequestParam("id")int id)
    {
        Enterprise carMessage=enterpriseService.findById(id);
        model.addAttribute("enterprise",carMessage);
        return "enterprise_show";
    }
    @RequestMapping(value = "/enterprise_change",method = RequestMethod.GET)
    public String change(Model model,@RequestParam("id")int id){
        Enterprise carMessage=enterpriseService.findById(id);
        model.addAttribute("enterprise",carMessage);
        return "enterprise_change";}
    @RequestMapping(value = "/del2",method = RequestMethod.GET)
    public String del1(@RequestParam("id") int id){
        Enterprise enterprise=enterpriseService.findById(id);
        if(enterprise!=null)
        {
            enterpriseService.delete(id);
            return "redirect:/enterprise_select";
        }
       return "redirect:/enterprise_show";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam Map<String,String> map){
         Enterprise enterprise=new Enterprise();
         enterprise.setEnterpriseSort(map.get("style"));
         enterprise.setEnterpriseName(map.get("name"));
         enterprise.setOperation(map.get("operation"));
         enterprise.setWorkArea(map.get("area"));
         enterprise.setAddress(map.get("address"));
         enterprise.setPhone(map.get("phone"));
         enterprise.setLinkMan(map.get("linkman"));
         enterprise.setHandSet(map.get("hand"));
         enterprise.setFax(map.get("fax"));
         enterprise.setEmail(map.get("email"));
         enterprise.setHttp(map.get("web"));
         enterprise.setIntro(map.get("intr"));
         int id= Integer.parseInt(map.get("id"));
         enterprise.setId(id);
         enterpriseService.update(enterprise);
         return "redirect:/enterprise_show?id="+id;
    }
}
