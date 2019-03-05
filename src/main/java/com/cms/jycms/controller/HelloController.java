package com.cms.jycms.controller;

import com.cms.jycms.domain.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: xuzhenxing
 * @Date: 2019/3/5 16:58
 * @Description:
 */
@RequestMapping("user")
@Controller
public class HelloController {
    @RequestMapping("sayHello")
    public String sayHello(Model model)
    {
        HelloModel helloModel=new HelloModel();
        helloModel.setSayHello("hello jycms");
        model.addAttribute("model",helloModel);
        return "/user/sayHello";
    }
}
