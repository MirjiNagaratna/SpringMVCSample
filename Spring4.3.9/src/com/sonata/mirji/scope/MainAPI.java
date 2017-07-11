package com.sonata.mirji.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("Beans.xml");
		Student student = (Student) applicationContext.getBean("student");
		student.setName("radha");
		System.out.println("Name of student: "+student.getName());
		
		Student student2 = (Student) applicationContext.getBean("student");
		System.out.println("Name of student2: "+student2.getName());
	}
}
