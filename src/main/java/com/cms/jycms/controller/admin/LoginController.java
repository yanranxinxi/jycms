package com.cms.jycms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class LoginController {
    @RequestMapping("login")
    public String login() {
        return "/admin/login";
    }

    @RequestMapping("index")
    public String index() {
        return "/admin/index";
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "/admin/welcome";
    }

    @RequestMapping("contentManager")
    public String memberlist() {
        return "/admin/contentManager";
    }

    @RequestMapping("contentAdd")
    public String contentAdd() {
        return "/admin/contentAdd";
    }

    @RequestMapping("error")
    public String error(){
        return "/admin/error";
    }

    @RequestMapping("systemManager")
    public String systemManager(){
        return "/admin/systemManager";
    }

    @RequestMapping("classManager")
    public String classManager(){
        return "/admin/classManager";
    }
}
