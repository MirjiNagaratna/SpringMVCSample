package com.sonata.mirji.java8;

import java.lang.reflect.Method;

public class ClassLoaderExample {

	public static void main(String[] args) {
		
		Student student = new Student();
		
		Class<? extends Student> stClass = student.getClass();
		System.out.println("getName"+stClass.getName());
		System.out.println("length: "+stClass.getMethods().length);
		for (Method method : stClass.getMethods()) {
			System.out.println("method: "+method.getName());
		}
		
		System.out.println("class Loader: "+stClass.getClassLoader());//Loadded by the application loader
		System.out.println("String class loader: "+String.class.getClassLoader());//Loadded by the bootstarp
		/*
		 * .class file generated properly ?
		 * .class file generated by the proper compiler
		 * initilize the class varible in o default values*/
		
		/**
		 * Initilization
		 * 1)bootstrap Loader :Core API jvm loades .
		 * 2)Extension Loader
		 * 3)Application Loadder */
		
		/**
		 * Only one method area in jvm : it is shared accross the Method area
		 * Heap Area information about all the object  */
		
	}
}
