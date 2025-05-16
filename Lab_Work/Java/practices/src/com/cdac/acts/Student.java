package com.cdac.acts;

public class Student{
	private long prn;
	private String name;
	private double fees;

	private static long basePRN= 25024012000L;

	// public static long getBasePrn(){
	// 	return basePRN;
	// }

	Student(){
		this.prn= 0;
		this.name= "";
		this.fees= 105000;
	}

	Student(String name){
		this.prn= ++basePRN;
		this.name= name;
		this.fees= 105000;
	}

	public void printStudent(){
		System.out.println("Student[ "
			+"PRN: "+ prn+ " "
			+"Name:"+ name+ " "
			+"Fees:"+ fees+ " "
			+"]"
		);
	}

	public static void main(String[] args){
		Student student1= new Student();
		Student student2= student1;

		student1.printStudent();
		// student2.printStudent("Pranit");

		Student student3= new Student("Pranit");
		student3.printStudent();
	}
}