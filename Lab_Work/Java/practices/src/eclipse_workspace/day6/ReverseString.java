package eclipse_workspace.day6;
import java.util.Scanner;

public class ReverseString {

	public void reverseString(String str) {
		
		String ReverseStr="";
		for(int i=str.length()-1;i>=0;i--) {
			ReverseStr+=str.charAt(i);
		}
		System.out.println(ReverseStr);
	}

	public static void main(String[] args) {
		ReverseString method=new ReverseString();
		Scanner sc= new Scanner(System.in);
		String str="";
		System.out.println("Enter a String: ");
		str=sc.nextLine();
		method.reverseString(str);
		

	}

}
