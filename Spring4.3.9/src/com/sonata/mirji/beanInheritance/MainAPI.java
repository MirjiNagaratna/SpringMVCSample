package com.sonata.mirji.beanInheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		Student student = (Student) applicationContext.getBean("studentInheriatnce");
		System.out.println(student.getName());
		System.out.println(student.getId());
		
		StudentClass studentcls = (StudentClass) applicationContext.getBean("studentClass");
		System.out.println(studentcls.getId());
		
	}
}
