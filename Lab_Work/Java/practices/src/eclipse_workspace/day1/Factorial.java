package eclipse_workspace.day1;

public class Factorial{

	public static void findFactorial(int n){
		int factorial=1;

			for(int i=1; i<=n; i++){
				factorial*=i;
				System.out.print(factorial+" ");
			}		
	}

	public static void main(String[] args){

		Factorial.findFactorial(5);
	}
}