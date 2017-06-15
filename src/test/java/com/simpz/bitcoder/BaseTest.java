package com.simpz.bitcoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	@SuppressWarnings("resource")
	public Object getBean(String name) {
		String[] path = { "spring.xml", "spring-mybatis.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		return ac.getBean(name);
	}
}
