package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinUsController {
    @Autowired
    private NavComponent navComponent;

    @RequestMapping("joinUs")
    public String joinUs(Model model)
    {
        model.addAttribute("navList", navComponent.getNavList());
        return "/web/joinUs";
    }
}
