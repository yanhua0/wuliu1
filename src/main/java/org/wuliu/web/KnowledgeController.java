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
import org.wuliu.entity.Knowledge;
import org.wuliu.service.KnowledgeService;

@Controller
@RequestMapping(value = "/")
public class KnowledgeController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KnowledgeService knowledgeService;
    @RequestMapping(value = "/knowledge_select",method = RequestMethod.GET)
    public String knowledge(Model model, @RequestParam(value = "page",defaultValue = "1",required = true) Integer page)
    {
        PageInfo<Knowledge> knowledge=knowledgeService.findpage(page);
        model.addAttribute("page",knowledge);
        return "knowledge_select";
    }
    @RequestMapping(value = "/knowledge_show",method = RequestMethod.GET)
    public String findById(Model model,@RequestParam("id") int id){
        Knowledge knowledge=knowledgeService.findById(id);
        model.addAttribute("knowledge",knowledge);
        return "knowledge_show";
    }
}
