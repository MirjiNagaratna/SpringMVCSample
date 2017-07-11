package com.sonata.mirji.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		ClassCollection classCollection = (ClassCollection) applicationContext.getBean("classCollection");
		classCollection.getIdNameMap();
		classCollection.getStudentIdList();
		classCollection.getStudentProp();
		
		
	}

}
