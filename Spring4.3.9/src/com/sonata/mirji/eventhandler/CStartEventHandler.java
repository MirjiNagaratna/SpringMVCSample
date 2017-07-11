package com.sonata.mirji.eventhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent paramE) {
		System.out.println("ContextStartedEvent started");
	}

}
