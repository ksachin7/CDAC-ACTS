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

	 public void printPattern3(int num){
		 for (int i = 0; i < num; i++) {
			 for (int j = 0; j < num; j++) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }
	 }

	public void printPattern4(int n){
		for(int i=n;i>0;i--){
			for(int j=0;j<i;j++){
				if(i%2==0){
					continue;
				}
				System.out.print("*");
			}
			if(i%2!=0){
					continue;
			}
			System.out.println(" ");
		}
		for(int i=0;i<=n;i++){
			for(int j=0;j<i;j++){
				if(i==1||i%2 == 0)
					continue;
				System.out.print("*");
			}
			if(i==0||i%2 == 0){
					continue;
			}
			System.out.println(" ");
		}
	}

	public void printPattern5(int num){
		for (int i = 1; i <=num; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <=num-i; j++) {
				System.out.print("*");
			}
			for (int j = num; j <= 2*num-i; j++) {
				System.out.print("+");
			}
			System.out.println();
		}
	}

	public void printPatternAlpha(int num){
		for (int i = 1; i <=num; i++) {
			char ch='A';
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <num-i; j++) {
				System.out.print(ch++);
			}
			for (int j = num; j <= 2*num-i; j++) {
				System.out.print(ch--);
			}
			System.out.println();
		}
	}

	public void printPatternAlpha2(int num){
		char ch='A';
		for (int i = 1; i <=num; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=num-i; j++) {
				System.out.print(ch);
			}
			for (int j = num; j <= 2*num-i; j++) {
				System.out.print(ch);
			}
			System.out.println();
			ch++;
		}
	}

	public void printPatternAlpha3(int num){
		char ch='A';
		for (int i = 1; i <=num; i++) {
			for (int j = 0; j < num-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <i; j++) {
				System.out.print(ch++);
			}
			for (int j = 1; j < i; j++) {
				System.out.print(ch++);
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
		System.out.println();
		pattern.printPattern5(5);
		System.out.println();
		pattern.printPatternAlpha(5);
		System.out.println();
		pattern.printPatternAlpha2(5);
		System.out.println();
		pattern.printPatternAlpha3(5);
	}
}