package com.sonata.mirji.eventhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent>{

	@Override
	public void onApplicationEvent(ContextStoppedEvent paramE) {
	System.out.println("ContextStoppedEvent");	
	}

}
