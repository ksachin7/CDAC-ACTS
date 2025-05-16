package com.acts.cdac;

import java.util.Scanner;
import java.util.Arrays;

public class Student {
	private int roll;
	private String name;
	private float marks;
	int size = 50;
	int index = 0;
	private Student[] students = new Student[size];

	public Student() {
	}

	public Student(int roll, String name, float marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public void addStudents(int roll, String name, float marks) {

		if (index >= size) {
			System.out.println("Max array size exceeds!");
			return;
		}
		students[index++] = new Student(roll, name, marks);
	}

	Student[] sortByMarks() {
//		Student[] temp = new Student[index];
//		Student temp = null;
//		int idx = 0;
//
//		for (int i = 0; i < index; i++) {
//			for (int j = 0; j < index - i - 1; j++) {
//				if (students[j].marks < students[j].marks) {
//					temp = students[i];
//					students[i] = students[++idx];
//					students[idx] = temp;
//				}
//			}
//		}
//		return students;
		
		for(int i=0;i<index ;i++) {
			for(int j=0;j<index-i-1;j++) {
				Student temp=new Student();
				if(students[j].marks>students[j+1].marks) {
					temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
			}
		}
		return students;
	}

	void findByRoll(int r) {
		for (int i = 0; i < index; i++) {
			if (students[i].roll == r) {
				System.out.println(students[i]);
			}
		}
	}

//	@Override
	public String toString() {
		return "Student[ Roll no: " + roll + ", Name: " + name + ", Marks: " + marks + " ]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello from Java!");

		Student student = new Student();
		
		while (true) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("1. Add Student\r\n"
						+ "2. Print Student by rollNo\r\n"
						+ "3. Print All students Sorted by Marks\r\n"
						+ "0. exit");
				System.out.println("Please enter your choice: ");
				int choice = sc.nextInt();
				
				switch (choice) {
				case 0: {
					System.out.println("Exiting the program...");
					System.exit(0);
//				break;
				}
				case 1:{
					System.out.println("Please enter roll no, name, and marks space separated.");
					student.addStudents(sc.nextInt(), sc.next(), sc.nextInt());
//				student.addStudents(2, "def", 30);
					break;
				}
				case 2:
					System.out.println("Please enter a roll no. to find: ");
					int r= sc.nextInt();
					student.findByRoll(r);
					break;
				case 3: 
					System.out.println(Arrays.toString(student.sortByMarks()));
					break;
				default:
					System.out.println("Invalid input!");
				}
			}

		}
	}
}
