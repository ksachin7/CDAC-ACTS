package com.cdac.acts;

import java.util.Scanner;

public class StringContains {

	public void stringContains(String str,String substr) {
		if(str.contains(substr)) {
			System.out.println("Substring is present in the string at: "+ str.indexOf(substr));
		}
		else {
			System.out.println("Substring is not present in the string.");
		}
	}

	public static void main(String[] args) {
		StringContains method=new StringContains();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String str=sc.nextLine();
		
		System.out.println("Enter a SubString: ");
		String substr=sc.nextLine();
		
		method.stringContains(str,substr);
		

	}

}
