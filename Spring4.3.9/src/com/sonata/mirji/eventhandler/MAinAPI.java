package com.sonata.mirji.eventhandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MAinAPI {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		applicationContext.start();
		HelloWorld helloWorld=(HelloWorld) applicationContext.getBean("helloWorld");
		System.out.println(helloWorld.getMsg());
		applicationContext.stop();
	}

}


