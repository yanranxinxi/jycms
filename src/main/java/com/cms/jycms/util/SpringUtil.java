package com.cms.jycms.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liusongrui Exp
 * @File SpringUtil.java Date: 2016年11月7日下午3:07:25-0400 2016
 * @since 1.0
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static Object getBean(Class<?> cls) {
		return getApplicationContext().getBean(cls);
	}

	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}