package com.cdac.acts;

public class StringOccurence {

	static int findOccurences(String str, String substr) {
		int count=0;
		
		for(int i=0; i< str.length(); i++) {
			if(str.contains(substr)) {
				count++;
				i+=str.lastIndexOf(substr)-str.indexOf(substr);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str= "This is string to find all occurences of a sub string";
		String substr="string";
		
		System.out.println("No. of occurences of word "+substr+" is: "+findOccurences(str, substr));
	}
}
