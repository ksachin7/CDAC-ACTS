package eclipse_workspace.day6;

import java.util.Arrays;

public class StringMethods {



	public static void main(String[] args) {
		String str1 = "String 1";
		String str2 = "String 2";
		
		// String Methods
		
		//1. length()
		System.out.println(" First String length is: "+str1.length());
		System.out.println(" Second String length is: "+str1.length());

		//2. charAt()
		System.out.println("Caharacter at last :"+str1.charAt(str1.length()-1));
		
		
		//3. compareTo()
		System.out.println(str1.compareTo(str2));
		
		// 4 endsWith()
		System.out.println(str2.endsWith("2"));
		
		//5. copyValueOf()
		char[] myStr1 = {'H', 'e', 'l', 'l', 'o'};
		String str3= "";
		str3= str3.copyValueOf(myStr1);
		
		
		//6.Split()
		String str4= "abc xyz";
		String[]arr= str4.split(" ");
		System.out.println(Arrays.toString(arr));
		for (int i=0; i<arr.length; i++) {
			  System.out.println(arr[i]);
		}
		
		String myStr = "Split a string by spaces, and also punctuation.";
		String regex = "[,\\.\\s]";
		String[] myArray = myStr.split(", ");
		for (int i=0; i<myArray.length; i++) {
			  System.out.println(myArray[i]);
		}
		
		System.out.println("Returned String: " + str3);
		
		
		//7.concat()
		System.out.println("Concated String is: "+str1.concat(str2));
		
		
		//8.join()
		String arr2[]= {"Orange", "Apple", "Mango"};
		String fruits = String.join(", ",arr2);
	    System.out.println(fruits);
	    
	    
	    //9.replace()
	    System.out.println(str1.replace("String", "NotString"));
	    
	    //10.toCharArr()
	    char StrArr[] = str1.toCharArray();
	    for(int i=0;i<StrArr.length;i++) {
	    	System.out.print("[ "+StrArr[i]);
	    }
//	    System.out.println("["+String.join(",",StrArr)+"]");
//	    System.out.println();

	}

}
