package com.sonata.mirji.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitClass implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object paramObject, String paramString) throws BeansException {
		System.out.println("paramObject"+paramObject);
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object paramObject, String paramString) throws BeansException {
		System.out.println("paramObject"+paramObject);
		return null;
	}

}
