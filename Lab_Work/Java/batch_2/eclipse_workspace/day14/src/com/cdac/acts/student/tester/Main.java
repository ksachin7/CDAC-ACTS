package com.cdac.acts.student.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.cdac.acts.student.Student;
import com.cdac.acts.student.StudentKey;

public class Main {

	private static Map<StudentKey, Student> studentMap = new HashMap<>();

	private static Scanner scanner = new Scanner(System.in);

	static void addStudent() {
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Roll No: ");
		Integer rollNo = scanner.nextInt();

		System.out.print("Enter Standard (e.g. 5): ");
		Integer standard = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter Division (e.g. A): ");
		String division = scanner.nextLine().toUpperCase();

		StudentKey key = new StudentKey(rollNo, standard, division);
		Student student = new Student(rollNo, name, standard, division, key);

		studentMap.put(key, student);
		System.out.println("Student added.");
	}

	private static Student findStudentByKey() {
		System.out.print("Enter Roll No: ");
		Integer rollNo = Integer.parseInt(scanner.nextLine());

		System.out.print("Enter Standard: ");
		Integer standard = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter Division: ");
		String division = scanner.nextLine().toUpperCase();

		StudentKey key = new StudentKey(rollNo, standard, division);
//		key != null ensures we’re not passing a null key 
//		which would throw a NullPointerException in containsKey()
		Student student = key != null  ? studentMap.get(key) : null;

		return student;
	}

	private static void printStudents() {
		if (studentMap.isEmpty()) {
			System.out.println("No students found!");
		} else {
			for (Map.Entry<StudentKey, Student> entry : studentMap.entrySet()) {
				System.out.println(""
//						entry.getKey() 
//						+ ": " 
						+ entry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		int choice = -1;

		System.out.println("" + "1. Add Student\n" + "2. Find Student by ID \n" + "3. Display Students\n");


		do {
			System.out.println("\nPlease enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addStudent();
				break;

			case 2:
				System.out.println(findStudentByKey());
				break;

			case 3:
				printStudents();
				break;

			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}
}
