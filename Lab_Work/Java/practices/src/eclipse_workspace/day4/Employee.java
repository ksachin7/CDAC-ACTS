package eclipse_workspace.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Employee {
	private int empid;
	private String empname;
	private double sal;

	public Employee() {
	}

	public Employee(int empid, String empname, double sal) {
		this.empid = empid;
		this.empname = empname;
		this.sal = sal;
	}

	public static void FindById(int id, Employee arr[], int index) {
		for (int i = 0; i < index; i++) {
			if (arr[i].empid == id) {
				System.out.println(arr[i]);
			}
		}
	}

	public static void SortArr(Employee arr[], int index) {
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < index - i - 1; j++) {
				Employee temp = new Employee();
				if (arr[j].sal > arr[j + 1].sal) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

//	@override
	public String toString() {
		return "[ Employee id: " + empid + ", Employee Name: " + empname + ", Salary: " + sal + " ]";
	}

	public static void main(String[] args) {
		Employee[] arr = new Employee[10];
		int index = 0;
		int choice = 0;
		while (true) {
			System.out.println("\n 0.Exit the program" + "\n 1.Add employee" + "\n 2. Print employee by id"
					+ "\n 3. Sort employee by salary");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 0: {
				System.out.println("Exited the program ! ");
				System.exit(0);
			}
			case 1: {
				int id;
				double sal;
				String name;
				System.out.println("Enter employee id: ");
				id = sc.nextInt();
				System.out.println("Enter employee name: ");
				name = sc.next();
				System.out.println("Enter employee salary: ");
				sal = sc.nextDouble();

				arr[index++] = new Employee(id, name, sal);

				break;
//				System.out.println(Arrays.toString(arr));

			}
			case 2: {
				System.out.println("Please enter a employee id to find: ");
				int id = sc.nextInt();
				Employee.FindById(id, arr, index);
				break;
			}
			case 3: {
				Employee.SortArr(arr, index);
			}
			}

		}
	}

}
