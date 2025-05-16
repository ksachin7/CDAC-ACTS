package com.acts.cdac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraylistPractice {
	
	public static void main(String []args) {
		List<String> list= new ArrayList<>();
		String []fruits= {"Mango", "Banana", "Orange"}; 
		list.addAll(Arrays.asList(fruits));
		
		System.out.println(list);
		
		list.add("Apple");
		list.forEach(System.out::println);
		
		System.out.println(list.indexOf("Apple"));
		System.out.println(list.lastIndexOf("Orange"));
		System.out.println(list.contains("xyz"));
		System.out.println(list.remove(1));
		System.out.println(list.remove("Orange"));
	}
}
