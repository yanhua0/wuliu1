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
import org.wuliu.entity.CarMessage;
import org.wuliu.entity.Customer;
import org.wuliu.service.CarMessageService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class CarMessageController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CarMessageService carMessageService;
    @RequestMapping(value = "/car_select",method = RequestMethod.GET)
    public String CarMessage(Model model, @RequestParam(value = "page",defaultValue = "1",required = true) Integer page)
    {
        PageInfo<CarMessage> p=carMessageService.findpage(page);
        model.addAttribute("page",p);
        return "car_select";
    }
    @RequestMapping(value = "/car_add",method = RequestMethod.GET)
    public String add()
    {
        return "car_add";
    }
    @RequestMapping(value = "/add2",method =RequestMethod.POST)
    public String add2(@RequestParam Map<String,String> map, HttpSession session)
    {   Customer c= (Customer) session.getAttribute("customer");
        int in=carMessageService.insert(map.get("numbers"),map.get("carname"),map.get("usetime"),map.get("name"),
                map.get("time"),map.get("phone"),map.get("meg"),map.get("type"),map.get("loads"),map.get("style"),map.get("number"),map.get("styles"),map.get("linkman"),c.getName());
    return "redirect:/car_select";
    }
    @RequestMapping(value = "/car_show",method = RequestMethod.GET)
    public String show(Model model,@RequestParam("id")int id)
    {
        CarMessage carMessage=carMessageService.findById(id);
        model.addAttribute("carmessage",carMessage);
        return "car_show";
    }
    @RequestMapping(value = "/car_change",method = RequestMethod.POST)
    public String change(Model model,@RequestParam Map<String,String> map){
        CarMessage carMessage=new CarMessage();
        carMessage.setLicenceNumber(map.get("s1"));
        carMessage.setDriverName(map.get("s2"));
        carMessage.setLicenceStyle(map.get("s3"));
        carMessage.setCarload(map.get("s4"));
        carMessage.setDriverTime(map.get("s5"));
        carMessage.setBrand(map.get("s6"));
        carMessage.setUserTime(map.get("userTime"));
        carMessage.setTradeMark(map.get("tradeMark"));
        carMessage.setStyle(map.get("style"));
        carMessage.setTranspotStyle(map.get("transpotStyle"));
        carMessage.setLinkMan(map.get("linkMan"));
        carMessage.setLinkPhone(map.get("phone"));
        carMessage.setRemark(map.get("remark"));
        int id= Integer.parseInt(map.get("id"));
         carMessage.setCode(id);


        carMessageService.update(carMessage);
        return "redirect:/car_show?id="+id;}
        /*
        删除
         */
        @RequestMapping(value = "/del1",method = RequestMethod.GET)
        public String del1(@RequestParam("id") int id){
            CarMessage carMessage=carMessageService.findById(id);
            if(carMessage!=null)
            {
                carMessageService.delete(id);
                return "redirect:/car_select";
            }
           return "redirect:/car_show";
        }
}
