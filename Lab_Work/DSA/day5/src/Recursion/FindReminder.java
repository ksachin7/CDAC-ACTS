package Recursion;

public class FindReminder {
	
	public static int reminder(int a, int b) {
		boolean isNegative = (a<0) ^ (b<0);
		a = Math.abs(a);
		b = Math.abs(b);
		if(b==0) {
			return -1;
		}
		if(a<b) {
			return a;
		}
		return isNegative ? -reminder(a-b,b):reminder(a-b,b); 
	}

	public static void main(String[] args) {
		System.out.println(reminder(-14,-3));

	}

}
