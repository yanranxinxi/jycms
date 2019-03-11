package com.cms.jycms.controller;

import com.cms.jycms.domain.UserModel;
import com.cms.jycms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: xuzhenxing
 * @Date: 2019/3/5 16:58
 * @Description:
 */
@RequestMapping("user")
@Controller
public class HelloController {
    @Autowired
    private UserMapper mapper;

    @RequestMapping("sayHello")
    public String sayHello(Model model) {
        List<UserModel> list = mapper.getList();
        model.addAttribute("list", list);
        return "/user/sayHello";
    }
}
