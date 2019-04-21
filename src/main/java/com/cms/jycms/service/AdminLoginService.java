package com.cms.jycms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {

    @Value("${hostName}")
    private String hostName;

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
        if (path.startsWith("/admin/login")) {
            return false;
        }

        return true;
    }

    /**
     * 检查是否已经登录
     *
     * @return
     */
    public boolean checkLogin() {
        return false;
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
