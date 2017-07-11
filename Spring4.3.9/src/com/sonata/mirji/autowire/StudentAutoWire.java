package com.sonata.mirji.autowire;

public class StudentAutoWire {
	
	public String id;

	public String getId() {
		System.out.println("getId");
		return id;
	}

	public void setId(String id) {
		System.out.println("setId"+id);
		this.id = id;
	}
	
	

}
