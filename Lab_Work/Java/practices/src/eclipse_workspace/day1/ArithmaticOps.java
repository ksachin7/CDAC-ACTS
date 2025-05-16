package eclipse_workspace.day1;
import java.util.Scanner;

public class ArithmaticOps{
	public static int add(int num1, int num2){
		return num1+num2;
	}

	public static int substract(int num1, int num2){
		return num1-num2;
	}

	public static int multiply(int num1, int num2){
		return num1*num2;
	}

	public static double divide(int num1, int num2){
		return num1/num2;
	}

	public static void main(String[] args){

		int choice, num1, num2;
		Scanner sc= new Scanner(System.in);

		System.out.println("Please enter your choice. \n1.Addition\n2.Substraction\n3.Multiplication\n4.Division: ");
		choice= sc.nextInt();

		System.out.println("Please enter number1: ");
		num1=sc.nextInt();

		System.out.println("Please enter number2: ");
		num2=sc.nextInt();

		switch(choice){
		case 1:
			System.out.println("Addition of two numbers are: "+ArithmaticOps.add(num1 ,num2));
			break;
		case 2:
			System.out.println("Substraction of two numbers are: "+ArithmaticOps.substract(num1 ,num2));
			break;
		case 3:
			System.out.println("Multiplication of two numbers are: "+ArithmaticOps.multiply(num1 ,num2));
			break;
		case 4:
			System.out.println("Division of two numbers are: "+ArithmaticOps.divide(num1 ,num2));
			break;
		default:
			System.out.println("Invalid Input! \nPlease enter a valid chice.");
		}
	}
}