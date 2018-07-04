package org.wuliu.web;

import com.github.pagehelper.PageInfo;
import javafx.scene.chart.ValueAxis;
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
import org.wuliu.entity.GoodsMeg;
import org.wuliu.service.GoodsMegService;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping(value = "/")
public class GoodsMegController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GoodsMegService goodsMegService;
    @RequestMapping(value = "/goods_select",method = RequestMethod.GET)
    public String CarMessage(Model model, @RequestParam(value = "page",defaultValue = "1",required = true) Integer page)
    {
        PageInfo<GoodsMeg> p=goodsMegService.findpage(page);
        model.addAttribute("page",p);
        return "goods_select";
    }
    @RequestMapping(value = "/goods_add",method = RequestMethod.GET)
    public String add()
    {
        return "goods_add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addSuccess(@RequestParam Map<String,String> map, HttpSession session)
    {   Customer customer= (Customer) session.getAttribute("customer");
        int i=goodsMegService.insert(map.get("gclass"),map.get("gcount"),map.get("startProvince")
       ,map.get("endProvince"),map.get("gtransstyle"),map.get("gphone"),map.get("gremark"),map.get("grequest"),
            map.get("gname"),map.get("gunit"),map.get("gstartcity"),map.get("gendcity"),map.get("gtime"),map.get("glink"),customer.getName());
        return "redirect:/goods_select";
    }
    /*
    物资显示
     */
    @RequestMapping(value = "/goods_xiangxi",method = RequestMethod.GET)
    public String xiangxi(Model model,@RequestParam("id") int id)
    {   GoodsMeg carMessage=goodsMegService.findById(id);
        model.addAttribute("goodsMsg",carMessage);
        return "goods_xiangxi";
    }
    /*
    物资修改页面
     */
    @RequestMapping(value = "/goods_change",method = RequestMethod.GET)
    public String change(Model model,@RequestParam("id")int id){
        GoodsMeg carMessage=goodsMegService.findById(id);
        model.addAttribute("goodsMsg",carMessage);
        return "goods_change";}
    @RequestMapping(value = "/del3",method = RequestMethod.GET)
    public String del1(@RequestParam("id") int id){
     GoodsMeg goodsMeg=goodsMegService.findById(id);
     if(goodsMeg!=null)
     {
         goodsMegService.delete(id);
         return "redirect:/goods_select";
     }
        return "redirect:/goods_show";
    }
    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public String sda(@RequestParam Map<String,String> map)
    {
        GoodsMeg goodsMeg=new GoodsMeg();
        goodsMeg.setGoodsStyle(map.get("gclass"));
        goodsMeg.setGoodsName(map.get("gname"));
        goodsMeg.setGoodsNumber(map.get("gcount"));
        goodsMeg.setGoodsUnit(map.get("gunit"));
        goodsMeg.setStartProvince(map.get("StartProvince"));
        goodsMeg.setStartCity(map.get("StartCity"));
        goodsMeg.setEndProvince(map.get("EndProvince"));
        goodsMeg.setEndCity(map.get("EndCity"));
        goodsMeg.setStyle(map.get("gtransstyle"));
        goodsMeg.setTransportTime(map.get("gtime"));
        goodsMeg.setPhone(map.get("gphone"));
        goodsMeg.setLink(map.get("glink"));
        goodsMeg.setRemark(map.get("gremark"));
        goodsMeg.setRequest(map.get("grequest"));
        int id= Integer.parseInt(map.get("id1"));
        goodsMeg.setId(id);
        goodsMegService.update(goodsMeg);
        return "redirect:/goods_change?id="+id;
    }

}
