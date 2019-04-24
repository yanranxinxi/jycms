package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
public class BrandController {
    @Autowired
    private NavComponent navComponent;
    @Autowired
    private NewsInfoService newsInfoService;

    @RequestMapping("brand")
    public String brand(Model model) {
        model.addAttribute("navList", navComponent.getNavList());
        return "web/brand";
    }

    @RequestMapping("/brand/curriculumSystem")
    public String curriculumSystem(Model model) {
        NewsInfo newsInfo = newsInfoService.selectByPrimaryKey("21");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/brand_subclass";
    }

    @RequestMapping("/brand/story")
    public String story(Model model) {
        NewsInfo newsInfo = newsInfoService.selectByPrimaryKey("22");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/brand_subclass";
    }

    @RequestMapping("/brand/aboutUs")
    public String aboutUs(Model model) {
        NewsInfo newsInfo = newsInfoService.selectByPrimaryKey("23");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/brand_subclass";
    }

    @RequestMapping("/brand/educationalConcept/{id}")
    public String educationalConcept(@PathVariable(value = "id") String id, Model model) {
        NewsInfo newsInfo = newsInfoService.selectByPrimaryKey(id);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/brand_subclass";
    }
}
