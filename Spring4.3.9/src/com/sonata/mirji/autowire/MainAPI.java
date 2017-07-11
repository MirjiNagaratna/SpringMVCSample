package com.sonata.mirji.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		ClassStudent classStudent = (ClassStudent) applicationContext.getBean("classStudent");
		classStudent.getAutoWire();
	}
}
