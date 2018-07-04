package org.wuliu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuliu.entity.Customer;
import org.wuliu.entity.Knowledge;
import org.wuliu.entity.Logistics;
import org.wuliu.enums.ResultEnum;
import org.wuliu.service.KnowledgeService;
import org.wuliu.service.LogisticsService;
import org.wuliu.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class ManagerController {
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private KnowledgeService knowledgeService;
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
}
