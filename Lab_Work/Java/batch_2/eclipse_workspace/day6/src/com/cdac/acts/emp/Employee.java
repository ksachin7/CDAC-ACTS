package com.cdac.acts.emp;
import com.cdac.acts.emp.Address;
import java.util.Scanner;

public class Employee {
	private String name;
	private int empno;
	private double sal;
	private Address address;
	
	
	public Employee() {
		
	}

	public Employee(String name, int empno, double sal,String country, int pincode, String city,String state) {
		this.name = name;
		this.empno = empno;
		this.sal = sal;
		this.address = new Address(country,pincode,city,state);
	}

	public String toString() {
		return "Employee [name=" + name + ", empno=" + empno + ", sal=" + sal + ", address=" + address + "]";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter employee id : ");
		int id=sc.nextInt();
		
		System.out.println("Enter employee name : ");
		String name=sc.next();
		
		System.out.println("Enter employee Country : ");
		String country=sc.next();
		
		System.out.println("Enter employee City : ");
		String city=sc.next();
		
		System.out.println("Enter employee State : ");
		String state=sc.next();
		
		System.out.println("Enter employee pincode : ");
		int pincode=sc.nextInt();
		
		System.out.println("Enter employee salary : ");
		double sal=sc.nextDouble();
		
		Employee emp = new Employee(name,id,sal,country,pincode,city,state);
		System.out.println(emp);
	}

}
