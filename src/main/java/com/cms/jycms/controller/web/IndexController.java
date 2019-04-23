package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private NavComponent navComponent;

    @RequestMapping({"/","index"})
    public String index(Model model) {
        model.addAttribute("navList", navComponent.getNavList());
        return "web/index";
    }
}
