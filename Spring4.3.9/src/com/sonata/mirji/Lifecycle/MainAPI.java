package com.sonata.mirji.Lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		ExampleBean exampleBean = (ExampleBean) applicationContext.getBean("exampleBean");
		exampleBean.getName();
	}
}
