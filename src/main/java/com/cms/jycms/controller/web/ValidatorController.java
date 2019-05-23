package com.cms.jycms.controller.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ValidatorController {
    @GetMapping("/validCode")
    public String validCode(HttpServletRequest httpServletRequest, String code) {
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if (code.equals(captchaId)) {
            return "1";
        }
        return "0";
    }
}
