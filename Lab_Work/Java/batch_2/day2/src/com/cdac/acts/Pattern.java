package com.cdac.acts;

public class Pattern{
	public void printPattern1(int num){
		for(int i=num; i>=0; i--){
			for(int j=0; j<i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}

	public void printPattern2(int num){
		for(int i=num; i>=0; i--){
			for(int j=num; j>i; j--){
				System.out.print('*');
			}
			System.out.println();
		}
	}

	public void printPattern3(int n){
	  for (int i = 0; i < n; i++) {
	  	int starsToPrint = n - i - (i == 0 ? 1 : 0);

        for (int j = 0; j < starsToPrint; j++) {
            System.out.print("*");
        }

        for (int j = 0; j < 2 * i - 1; j++) {
            System.out.print(" ");
        }

        for (int j = 0; j < n - i; j++) {
            System.out.print("*");
       	}
        System.out.println();
    	}
	}

	public void printPattern4(int num){
        int upperPartRows = num / 2; 
        for (int i = 0; i < upperPartRows; i++) {
            for (int j = 0; j < num - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
		System.out.println("*");
        // Lower part of the pattern
        int lowerPartRows = num / 2; 
        for (int i = 0; i < lowerPartRows; i++) {
            for (int j = 0; j < 3 + 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

	}

	public static void main(String[] args){
		Pattern pattern= new Pattern();
		pattern.printPattern1(5);

		System.out.println();
		pattern.printPattern2(5);

		System.out.println();
		pattern.printPattern3(5);

		System.out.println();
		pattern.printPattern4(5);
	}
}