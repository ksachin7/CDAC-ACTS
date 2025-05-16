package eclipse_workspace.day1;
import java.util.Scanner;

public class CalculateIntrest{

	public static double calculateSimpleInterest(double p, double r, int t){
		return (p*r*t)/100;
	}

	public static double calculateCompoundInterest(double p, double r, int t, int n){
		double result=0;
		result= Math.pow((p*(1+r/n)), n*t)-p;
		return result;
	}

	public static void main(String[] args){
		int choice, t, n;
		double p, r;
		Scanner sc= new Scanner(System.in);

		do{
			// A = amount
			// P = principal
			// r = rate of interest
			// n = number of times interest is compounded per year
			// t = time (in years)

			System.out.println("Please enter your choice. \n1.Simple interest\n2.Compound interest\n3.Exit");
			choice= sc.nextInt();

			switch(choice){
			case 1:{
				System.out.println("Please enter principal amount: ");
				p=sc.nextDouble();

				System.out.println("Please enter rate of interest: ");
				r=sc.nextDouble();

				System.out.println("Please enter time (in years): ");
				t=sc.nextInt();

				System.out.println("Simple interest= "+CalculateIntrest.calculateSimpleInterest(p, r, t));
				break;
			}
			case 2:{
				System.out.println("Please enter principal amount: ");
				p=sc.nextDouble();

				System.out.println("Please enter rate of interest: ");
				r=sc.nextDouble();

				System.out.println("Please enter time (in years): ");
				t=sc.nextInt();

				System.out.println("Please enter number of times interest is compounded per year: ");
				n=sc.nextInt();

				System.out.println("Compound interest= "+CalculateIntrest.calculateCompoundInterest(p, r, t, n));
				break;
			}
			case 3: break;
			default:
				System.out.println("Invalid Input! \nPlease enter a valid chice!");
			}
		}while(choice != 3);
	}
}