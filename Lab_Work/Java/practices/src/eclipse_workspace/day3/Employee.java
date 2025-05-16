package eclipse_workspace.day3;
import java.util.Scanner;

public class Employee{
		private static int count=0;
		private int empNo;
		private String name;
		private double salary;

		Employee(){
			this.empNo=0;
			this.name="";
			this.salary=0;
		}

		Employee(String name,double salary){
			this.empNo=++count;
			this.name=name;
			this.salary=salary;
		}
		
		public void PrintData(){
			System.out.println(
				"Employee no: "+empNo+", "
				+"Employee Name:"+name+", "
				+"Employee salary:"+salary
			);
		}

	public static void main(String[] args){
		// int n;
		double sal;
		String name;
		Scanner sc= new Scanner(System.in);
		// System.out.println("Enter Employee no : ");
		// n=sc.nextInt();
		Employee[] emp;
		emp=new Employee [5];

		for(int i=0;i<5;i++){
				System.out.println("Enter Employee name : ");
				name=sc.next();
				System.out.println("Enter Employee salary : ");
				sal=sc.nextDouble();
				emp[i]=new Employee(name,sal);
		}

		for(int i=0;i<5;i++){
			emp[i].PrintData();
		}

	}

}