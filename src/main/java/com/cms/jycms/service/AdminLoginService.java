package com.cms.jycms.service;

import com.cms.jycms.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminLoginService {

    @Value("${hostName}")
    private String hostName;

    private String loginAttr = "loginUserInfo";

    /**
     * path 是否需要登录
     *
     * @param path
     * @return
     */
    public boolean isNeedLogin(String path) {
        // /admin 开头的都要验证
        if (!path.startsWith("/admin/")) {
            return false;
        }

        // 登录界面 无需验证
        if (path.startsWith("/admin/login") || path.startsWith("/admin/api/checkLogin")) {
            return false;
        }

        return true;
    }

    public void login(HttpSession session, UserInfo userInfo) {
        session.setAttribute(loginAttr, userInfo);
    }

    public void loginOut(HttpSession session) {
        session.removeAttribute(loginAttr);
    }

    /**
     * 检查是否已经登录
     *
     * @return
     */
    public boolean checkLogin(HttpSession session) {
        return getLoginUserInfo(session) != null;
    }

    public UserInfo getLoginUserInfo(HttpSession session) {
        return (UserInfo) session.getAttribute(loginAttr);
    }

    public boolean isApi(String path) {
        if (path.startsWith("/admin/api/")) {
            return true;
        }
        return false;
    }

    /**
     * 获取登录URL
     *
     * @return
     */
    public String getAdminLoginUrl() {
        return hostName + "/admin/login";
    }

}
