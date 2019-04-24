package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinUsController {
    @Autowired
    private NavComponent navComponent;
    @Autowired
    private NewsInfoService service;

    @RequestMapping("joinUs")
    public String joinUs(Model model) {
        NewsInfo newsInfo = service.selectByPrimaryKey("25");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/joinUs";
    }

    @RequestMapping("/joinUs/contact")
    public String contact(Model model) {
        NewsInfo newsInfo = service.selectByPrimaryKey("24");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("newsInfo", newsInfo);
        return "web/contact";
    }
}
