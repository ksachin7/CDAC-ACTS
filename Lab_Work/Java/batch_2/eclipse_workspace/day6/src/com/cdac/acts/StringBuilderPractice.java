package com.cdac.acts;


public class StringBuilderPractice {

	public StringBuilderPractice() {
		
}

	public static void main(String[] args) {
		StringBuilder builder= new StringBuilder();
		builder.append("xyz");
		System.out.println(builder);
		
		String palindrome = " is not a palindrome!";
		builder.append(palindrome);
		System.out.println(builder);
		
		builder.reverse();
		System.out.println(builder);
		
		System.out.println(builder.capacity());	// 34
		System.out.println(builder.length());	// 23
		System.out.println(builder.charAt(3));
		
		builder.insert(0,'1');
		System.out.println(builder);
		
		
		builder.replace(3, 5,"Insert");
		System.out.println(builder);
		
		builder.deleteCharAt(0);
		System.out.println(builder);
		
//		builder.compareTo(palindrome);
		System.out.println(builder.getClass());
		
		String str= new String("An example String");
		builder.replace(0, builder.length(), str);
		System.out.println(builder+" "+builder.length()+ " "+str.length());
		System.out.println(builder.equals(str));
		
		// ----------- String Practice
		 String str2= builder.toString();
		 String str1 = "1!emordnilap a ton si zyx";
			System.out.println("String : " +str1);
			System.out.println("Builder: "+builder);
			
		System.out.println("Substr:"+builder.substring(0, 6));
		 
		 if(str2.equals(str1)) {
			 System.out.println("Strings are same");
		 }
		 else {
			 System.out.println("Strings are differents");
		 }
		 if(str2==str1) {
			 System.out.println("Refernce are same");
		 }
		 else {
			 System.out.println("Referance are differents");
		 }
		 
		  String str3=str2.intern();
		 
		 if(str3==str1) {
			 System.out.println("Refernce are same");
		 }
		 else {
			 System.out.println("Refernce are differents");
		 }
			 
	}

}
