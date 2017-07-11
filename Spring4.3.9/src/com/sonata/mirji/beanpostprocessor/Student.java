package com.sonata.mirji.beanpostprocessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean , DisposableBean{
	public String name;

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
	
	
}
