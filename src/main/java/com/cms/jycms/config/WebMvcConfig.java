package com.cms.jycms.config;

import com.cms.jycms.config.interceptor.AdminLoginInterceptor;
import com.cms.jycms.config.interceptor.LogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Autowired
    private LogInterceptor logInterceptor;

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/api/**");
    // }

    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("/resources/**").addResourceLocations(
    // "/resources/");
    // }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false).
                setUseTrailingSlashMatch(true);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.debug("------------------------------------WebMvcConfig addInterceptors ");
        registry.addInterceptor(logInterceptor);
        registry.addInterceptor(adminLoginInterceptor);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(error401Page, error404Page);
        });
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
