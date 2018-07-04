package org.wuliu.web;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuliu.entity.Logistics;
import org.wuliu.service.LogisticsService;

@Controller
@RequestMapping(value = "/")
public class LogisticsController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LogisticsService logisticsService;
    @RequestMapping(value = "/active_select",method = RequestMethod.GET)
    public String findByPage(@RequestParam(value = "page",defaultValue = "1",required = true) Integer page, Model model)
    {
        PageInfo<Logistics> p=logisticsService.findpage(page);
        model.addAttribute("page",p);
        return "active_select";
    }
    @RequestMapping(value ="/active_show",method = RequestMethod.GET)
    public String findshow(Model model,@RequestParam("id") int id)
    {
        Logistics logistics=logisticsService.findById(id);
        model.addAttribute("log",logistics);
        return "active_show";
    }
}
