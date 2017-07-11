package com.sonata.mirji.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8sort {

	public static void main(String[] args) {
		List<String> nameList1 = new ArrayList<String>();
		
		nameList1.add("nagaratna");
		nameList1.add("mirji");
		nameList1.add("kavya");
		nameList1.add("jaya");
		
		System.out.println("Sorting by java7");
		Java8sort java8sort = new Java8sort();
		java8sort.java7Sort(nameList1);
		System.out.println(nameList1);
		
		System.out.println("Sorting java7SortWithoutComparator");
		java8sort.java7SortWithoutComparator(nameList1);
		System.out.println(nameList1);
		
		System.out.println("Sorting java8 ");
		java8sort.java8Sort(nameList1);
		System.out.println(nameList1);
	}

	public void java7Sort(List<String> nameList){
		Collections.sort(nameList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}
	
	public void java7SortWithoutComparator(List<String> nameList){
		Collections.sort(nameList);
	}
	
	//lambda 
	private void java8Sort(List<String> nameList1) {
		Collections.sort(nameList1, (s1,s2)-> s1.compareTo(s2));
	}
}
