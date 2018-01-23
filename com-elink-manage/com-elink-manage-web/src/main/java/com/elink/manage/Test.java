package com.elink.manage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aa.xml");
		TestAspect testAspect = (TestAspect)applicationContext.getBean("testAspect");
		testAspect.add(2, 6);
		
	}
}
