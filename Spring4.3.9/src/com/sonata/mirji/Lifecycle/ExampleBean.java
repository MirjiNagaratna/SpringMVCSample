package com.sonata.mirji.Lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExampleBean implements InitializingBean , DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initlization method invoke when the bean initiated");
	}
	
	public void init(){
		System.out.println("init method");
	}
	
	public String name;

	public String getName() {
		System.out.println("ExampleBean getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("ExampleBean setName");
		this.name = name;
	}

	@Override
	public void destroy() throws Exception {
	System.out.println("ExampleBean destroy");
	}
	
	

}
