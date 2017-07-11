package com.sonata.mirji.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {

	public static void main(String[] args) {
		/*normal java */
		
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMsg("hi");
		helloWorld.getMsg();
		
		
		/*Spring Example*/
		  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		  HelloWorld helloWorld2 =  (HelloWorld) context.getBean("helloWorldBean");
		  helloWorld2.getMsg();
		
	}
}
