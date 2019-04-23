package com.cms.jycms.service;

import com.cms.jycms.domain.UserInfo;
import com.cms.jycms.util.Md5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminLoginService {

    @Value("${web.hostName}")
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

    /**
     * 登录
     *
     * @param session
     * @param userInfo
     */
    public void login(HttpSession session, UserInfo userInfo) {
        // 30分钟超时
        session.setMaxInactiveInterval(30 * 60);
        // 记录登录信息
        session.setAttribute(loginAttr, userInfo);
    }

    /**
     * 登出
     *
     * @param session
     */
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

    /**
     * 获取登录信息
     *
     * @param session
     * @return
     */
    public UserInfo getLoginUserInfo(HttpSession session) {
        return (UserInfo) session.getAttribute(loginAttr);
    }

    /**
     * 路径是否 api 接口
     *
     * @param path
     * @return
     */
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
