package com.cms.jycms.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.cms.jycms.common.R;
import com.cms.jycms.service.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminLoginService adminLoginService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 验证是否需要登录
        String uri = request.getRequestURI();
        String hostName = request.getServerName();
        logger.warn(hostName);
        if (!adminLoginService.isNeedLogin(uri)) {
            return true;
        }

        // 验证是否已经登录
        if (adminLoginService.checkLogin()) {
            return true;
        }

        // 处理登录
        try {
            if (adminLoginService.isApi(uri)) {
                logger.warn("用户未登录请求 API：{}", uri);
                ServletOutputStream outputStream = response.getOutputStream();
                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);
                response.setContentType("application/json");
                outputStream.write(JSON.toJSONString(R.error(-300, "用户未登录")).getBytes("utf-8"));
                outputStream.flush();
                outputStream.close();
            } else {
                logger.warn("用户未登录访问：{}", uri);
                String loginUrl = adminLoginService.getAdminLoginUrl();
                response.sendRedirect(loginUrl);
            }
        } catch (Exception e) {
            logger.error("preHandle", e);
        }
        return false;
    }


    /**
     * 解释出来的用户信息放到ModelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

}
