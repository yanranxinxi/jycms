package com.cms.jycms.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.cms.jycms.util.RemoteIPUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录请求相关日志
 *
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = Logger.getLogger(LogInterceptor.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        startTime.set(System.currentTimeMillis());
        String ip = RemoteIPUtil.getAddr(request);
        logger.debug(String.format("IP:%s URI: %s", ip, request.getServletPath()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        long totalTime = System.currentTimeMillis() - startTime.get();
        if (totalTime < 1000) {
            logger.debug(String.format("耗时: %d ms URI: %s ", totalTime, request.getServletPath()));
        } else {
            String param = JSON.toJSONString(request.getParameterMap());
            logger.warn(String.format("\n>>>>>请求超过1秒 URI: %s \n>>>>>参数: %s \n>>>>>耗时: %d ms ",
                    request.getServletPath(), param, totalTime));
        }
    }
}