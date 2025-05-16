package com.cdac.acts.student;

import java.util.Objects;

public class Student {
	private Integer rollNo;
	private String name;
	private Integer standard;
	private String division;
	private StudentKey studId;
	public Student(Integer rollNo, String name, Integer standard, String division, StudentKey studId) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.standard = standard;
		this.division = division;
		this.studId = studId;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + ", division=" + division
				+ ", studId=" + studId + "]";
	}
	
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public StudentKey getStudId() {
		return studId;
	}
	public void setStudId(StudentKey studId) {
		this.studId = studId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(division, name, rollNo, standard, studId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(division, other.division) && Objects.equals(name, other.name)
				&& Objects.equals(rollNo, other.rollNo) && Objects.equals(standard, other.standard)
				&& Objects.equals(studId, other.studId);
	}
}
