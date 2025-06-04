package Recursion;

public class FindQuotient {
	
	public static int quotient(int a,int b) {
		boolean isNegative = (a<0)^(b<0) ;
		a = Math.abs(a);
		b = Math.abs(b);
		if(b==0) {
			return -1;
		}
		if(a<b) {
			return 0;
		}
		return isNegative ?  -1 - quotient(a-b,b) : 1 + quotient(a-b,b) ;
	}

	public static void main(String[] args) {
		System.out.println(quotient(-4,2));

	}

}
