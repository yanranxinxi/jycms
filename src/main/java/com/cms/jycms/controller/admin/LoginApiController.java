package com.cms.jycms.controller.admin;

import com.cms.jycms.common.R;
import com.cms.jycms.domain.UserInfo;
import com.cms.jycms.service.AdminLoginService;
import com.cms.jycms.service.UserInfoService;
import com.cms.jycms.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin/api")
public class LoginApiController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HttpSession session;

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping("checkLogin")
    public R checkLogin(String username, String password) {
        UserInfo userInfo = userInfoService.selectByUserName(username);
        if (userInfo == null) {
            return R.error(-1, "用户名或密码不正确");
        }

        String sign = Md5Util.sign(password);
        if (sign.equalsIgnoreCase(userInfo.getPassword())) {
            adminLoginService.login(session, userInfo);
            return R.ok("/admin/index");
        }
        return R.error(-1, "用户名或密码不正确");
    }

    @RequestMapping("loginOut")
    public R loginOut() {
        adminLoginService.loginOut(session);
        return R.ok("/admin/index");
    }

}
