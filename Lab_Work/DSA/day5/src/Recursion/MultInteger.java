package Recursion;

public class MultInteger {
	
	public static int multiply(int a,int b) {
		if(a == 0 || b == 0) {
			return 0;
		}
		if(a>0 && b>0) {
			return a + multiply(a,b-1);
		}
		if(a<0 && b>0) {
			return a + multiply(a,b-1); 
		}
		if(a>0 && b<0) {
			return b + multiply(a-1,b);
		}
		return -a + multiply(a,b+1);
	}

	public static void main(String[] args) {
		System.out.println(multiply(-2,-3));

	}

}
