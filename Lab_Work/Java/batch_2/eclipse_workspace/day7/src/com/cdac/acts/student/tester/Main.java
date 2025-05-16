package com.cdac.acts.student.tester;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import com.cdac.acts.student.Course;
import com.cdac.acts.student.Student;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Student[] students = new Student[10]; // fixed-size array
		int count = 0;

		while (count < students.length) {
			System.out.println("Enter 1 to add student, 0 to stop:");
			int choice = sc.nextInt();
			sc.nextLine(); // consume leftover newline

			if (choice == 0) {
				break;
			} else if (choice == 1) {
				System.out.print("Enter name: ");
				String name = sc.nextLine();

				System.out.print("Enter roll number: ");
				int roll = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter course (e.g., PG_DAC): ");
				String courseName = sc.next().toUpperCase();
				sc.nextLine();
				Course course = Course.valueOf(courseName);

				System.out.print("Enter DOB (yyyy-mm-dd): ");
				String dobStr = sc.next();
				sc.nextLine();
				LocalDate dob = LocalDate.parse(dobStr);

				students[count++] = new Student(name, roll, course.getValue(), dob);
			} else {
				System.out.println("Invalid choice. Try again.");
			}
		}

		sc.close();

		// Print all entered students
		System.out.println("\n--- Student Data ---");
		for (int i = 0; i < count; i++) {
			System.out.println(students[i]);
		}

		// Sort by DOB
		System.out.println("\n--- Students Sorted by DOB ---");
		Student[] toSort = Arrays.copyOf(students, count);
		Student.sortByDOB(toSort);
		for (Student s : toSort) {
			System.out.println(s);
		}
	}
}
