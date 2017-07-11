package com.sonata.mirji.autowire;

import com.sonata.mirji.beanInheritance.StudentClass;

public class ClassStudent {
	
	public StudentAutoWire autoWire ;

	public StudentAutoWire getAutoWire() {
		System.out.println("getAutoWire"+autoWire);
		return autoWire;
	}

	public void setAutoWire(StudentAutoWire autoWire) {
		System.out.println("setAutoWire");
		this.autoWire = autoWire;
	}
	
	

}
