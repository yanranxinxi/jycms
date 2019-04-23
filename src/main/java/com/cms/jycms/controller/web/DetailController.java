package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {
    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private NavComponent navComponent;

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        NewsInfo newsInfo = newsInfoService.selectByPrimaryKey(id);
        model.addAttribute("newsInfo", newsInfo);
        model.addAttribute("navList", navComponent.getNavList());
        return "/web/detail";
    }
}
