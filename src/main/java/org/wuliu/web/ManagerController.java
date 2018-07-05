package org.wuliu.web;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuliu.entity.Customer;
import org.wuliu.entity.Knowledge;
import org.wuliu.entity.Logistics;
import org.wuliu.entity.Placard;
import org.wuliu.enums.ResultEnum;
import org.wuliu.service.CustomerService;
import org.wuliu.service.KnowledgeService;
import org.wuliu.service.LogisticsService;
import org.wuliu.service.PlacardSerivce;
import org.wuliu.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class ManagerController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PlacardSerivce placardSerivce;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Man()
    {return "manager"; }
    @RequestMapping(value = "/active_add",method = RequestMethod.GET)
      public String AC(){return "active_add";
    }
    @RequestMapping(value = "/knowledge_add",method = RequestMethod.GET)
    public String AC2(){return "knowledge_add";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public Result cc(HttpSession session)
    {   Customer customer= (Customer) session.getAttribute("customer");
        if(customer.getPow().equals("2"))
        {
            return new Result(ResultEnum.ADMIN);
        }
        else{
            return new Result(ResultEnum.FAIL);
        }
    }
    /*
    物流信息修改删除添加
     */
    @RequestMapping(value = "/logupdate",method = RequestMethod.POST)
    public String updateLog(@RequestParam Map<String,String> map)
    {
        Logistics logistics=new Logistics(map.get("title"),map.get("content"),Integer.parseInt(map.get("id")));
        logisticsService.update(logistics);
        return "redirect:/active_show?id="+Integer.parseInt(map.get("id"));
    }
    @RequestMapping(value = "/logdel",method = RequestMethod.GET)
    public String del11(@RequestParam("id")int id)
    {  Logistics logistics=logisticsService.findById(id);
    if(logistics!=null)
    {
        logisticsService.delete(id);
        return "redirect:/active_select";
    }
        return "redirect:/active_show?id="+id;
    }
    @RequestMapping(value = "/loginsert",method = RequestMethod.POST)
    public String insert11(@RequestParam Map<String,String>map)
    {
      Logistics logistics=new Logistics(map.get("title"),map.get("content"),map.get("author"));
      logisticsService.insert(logistics);
      return "redirect:/active_select";
    }

    @RequestMapping(value = "/knowupdate",method = RequestMethod.POST)
    public String updateLog1(@RequestParam Map<String,String> map)
    {
        Knowledge knowledge=new Knowledge(map.get("title"),map.get("content"),Integer.parseInt(map.get("id")));
        knowledgeService.update(knowledge);
        return "redirect:/knowledge_show?id="+Integer.parseInt(map.get("id"));
    }
    @RequestMapping(value = "/knowdel",method = RequestMethod.GET)
    public String del112(@RequestParam("id")int id)
    {   Knowledge knowledge=knowledgeService.findById(id);
        if(knowledge!=null)
        {
            knowledgeService.delete(id);
            return "redirect:/knowledge_select";
        }
        return "redirect:/knowledge_show?id="+id;
    }
    @RequestMapping(value = "/knowinsert",method = RequestMethod.POST)
    public String insert112(@RequestParam Map<String,String>map)
    {
        Knowledge knowledge=new Knowledge(map.get("title"),map.get("content"),map.get("author"));
        knowledgeService.insert(knowledge);
        return "redirect:/knowledge_select";
    }
    /*
    会员信息修改删除查询
     */
    @RequestMapping(value = "/member_select",method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page",defaultValue = "1",required = true) Integer page, Model model){
        PageInfo<Customer> p=customerService.findpage(page);
        model.addAttribute("page",p);
        return "member_select";
    }
    @RequestMapping(value ="/member_change",method = RequestMethod.GET)
    public String change(@RequestParam("id") int id,Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer",customer);
        return "member_change";}
    @RequestMapping(value = "/change",method =RequestMethod.POST)
    @ResponseBody
    public Result update(Customer customer,HttpSession session){
        Customer customer1= (Customer) session.getAttribute("customer");
         Result result1=customerService.updateAll(customer,customer.getName(),session);
         return result1;
//        return "redirect:/admin/member_change?id="+customer.getId();
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String del(@RequestParam("id")int id){
        Customer customer=customerService.findById(id);
        if(customer!=null)
        {
            customerService.delete(id);
            return "redirect:/admin/member_select";
        }
        return "redirect:/admin/member_select";
    }
    /*
    公告信息查询、修改、删除
     */
    @RequestMapping(value = "/placard_change",method = RequestMethod.GET)
    public String updateUI(@RequestParam("id") int id,Model model)
    {  Placard placard=placardSerivce.findById(id);
       model.addAttribute("placard",placard);
        return "placard_change";
    }

    @RequestMapping(value = "/pc",method = RequestMethod.POST)
    public String updateLog(Placard placard)
    {   placardSerivce.update(placard);
        return "redirect:/admin//placard_change?id="+placard.getId();
    }
    @RequestMapping(value = "/pladel",method = RequestMethod.GET)
    public String del1111(@RequestParam("id")int id)
    {  Placard placard=placardSerivce.findById(id);
        if(placard!=null)
        {
            placardSerivce.delete(id);
            return "redirect:/admin/placard_select";
        }
        return "redirect:/admin/placard_select";
    }
    @RequestMapping(value = "placard_add",method = RequestMethod.GET)
    public String add2()
    {
        return "placard_add";
    }
    @RequestMapping(value = "/pla_insert",method = RequestMethod.POST)
    public String Plainsert11(Placard placard)
    {
        placardSerivce.insert(placard);
        return "redirect:/admin/placard_select";
    }
    @RequestMapping(value = "/placard_select",method = RequestMethod.GET)
    public String knowledge(Model model, @RequestParam(value = "page",defaultValue = "1",required = true) Integer page)
    {
        PageInfo<Placard> p=placardSerivce.findpage(page);
        model.addAttribute("page",p);
        return "placard_select";
    }

}

