package com.sonata.mirji.injectingBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPI {
	public static void main(String[] args) {
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor textEditor = (TextEditor) applicationContext.getBean("textEditor");
		textEditor.checkSpell();
	}
}
