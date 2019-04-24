package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    @Autowired
    private NavComponent navComponent;

    @RequestMapping("course")
    public String course(Model model) {
        model.addAttribute("navList", navComponent.getNavList());
        return "web/course";
    }
    @RequestMapping("/course/3-6")
    public String course36(Model model)
    {
        model.addAttribute("navList", navComponent.getNavList());
        return "web/course_3_6";
    }

    @RequestMapping("/course/2-6")
    public String course26(Model model)
    {
        model.addAttribute("navList", navComponent.getNavList());
        return "web/course_2_6";
    }
}
