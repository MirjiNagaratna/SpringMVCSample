package com.sonata.mirji.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {
	public static void main(String[] args) {
		AbstractApplicationContext  applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		Student student = (Student) applicationContext.getBean("student1");
		student.getName();
		applicationContext.registerShutdownHook();  
	}
}
