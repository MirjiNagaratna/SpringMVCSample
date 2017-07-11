package com.sonata.mirji.java8;

public class LamadaExamples {
	
	public static void main(String[] args) {
		//with type
		MathOpertaion add = (int a , int b) -> a + b;
		
		//Without type
		MathOpertaion sub = (a, b ) ->a - b;
		
		//With return statement
		MathOpertaion mult = (int a , int b) -> {return  a * b;};
		
		MathOpertaion div = (int a, int b) -> a / b;
		
		LamadaExamples examples = new LamadaExamples();
		System.out.println("example add" +examples.operator(10,20,add));
		System.out.println("example sub" +examples.operator(10,20,sub));
		System.out.println("example mult" +examples.operator(10,20,mult));
		System.out.println("example div" +examples.operator(10,20,div));
		
		//Without parantesies
		GreetingService greetingService = msg -> System.out.println("msg" +msg);
		
		//With parentesies
		GreetingService greetingService2 = (msg) -> System.out.println("hell0 "+ msg);
		
		greetingService.sayMesg("nagaratna");
		greetingService2.sayMesg("mirji");
	}
	
	private  int operator(int a,int b ,MathOpertaion mathOpertaion ){
		return mathOpertaion.opertor(a, b);
	}
	
	interface MathOpertaion{
		int opertor(int a, int b);
	}
	
	interface GreetingService{
		void sayMesg(String msg);
	}

}

