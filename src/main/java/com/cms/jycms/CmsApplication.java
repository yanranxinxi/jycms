package com.cms.jycms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: xuzhenxing
 * @Date: 2019/3/5 16:59
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.cms.jycms.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
