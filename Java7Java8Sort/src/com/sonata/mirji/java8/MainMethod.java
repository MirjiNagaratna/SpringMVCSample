package com.sonata.mirji.java8;

public class MainMethod {

	static{
		int a = 6;
		doSomething(a);
	}
	
	public static void  doSomething(int a){
		System.out.println("hello static block " + a);
	}


	public static void main(String[] args) {
		System.out.println("hello");
	}
	
	/**Main method is not complasory in Java till Java 5 later version it is complosry*/
}
