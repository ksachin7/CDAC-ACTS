package eclipse_workspace.day7.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
	private String name;
	private int roll_no;
	private String course;
	private LocalDate dob;

	public Student() {}

	public Student(String name, int roll_no, String course, LocalDate dob) {
		this.name = name;
		this.roll_no = roll_no;
		this.course = course;
		this.dob = dob;
	}

	public static void sortByDOB(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i] != null && students[j] != null) {
					if (students[i].getDob().isAfter(students[j].getDob())) {
						Student temp = students[i];
						students[i] = students[j];
						students[j] = temp;
					}
				}
			}
		}
	}

//	getter() setter() toString()
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Name: " + name +
				", Roll: " + roll_no +
				", Course: " + course +
				", DOB: " + dob.format(formatter);
	}

}
