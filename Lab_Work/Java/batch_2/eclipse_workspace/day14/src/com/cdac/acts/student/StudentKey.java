package com.cdac.acts.student;

import java.util.Objects;

public final class StudentKey implements Comparable<StudentKey> {
	final private Integer rollNo;
	final private Integer standard;
	final private String division;
	
	public StudentKey(Integer rollNo, Integer standard, String division) {
		this.rollNo = rollNo;
		this.standard = standard;
		this.division = division;
	}

	@Override
	public int hashCode() {
		return Objects.hash(division, rollNo, standard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentKey other = (StudentKey) obj;
		return Objects.equals(division, other.division) && Objects.equals(rollNo, other.rollNo)
				&& Objects.equals(standard, other.standard);
	}

//	@Override
//	public String toString() {
//		return "StudentKey [rollNo=" + rollNo + ", standard=" + standard + ", division=" + division + "]";
//	}
    
    @Override
    public String toString() {
        return String.valueOf(hashCode());
    }

	@Override
	public int compareTo(StudentKey o) {
		int rcmp = this.rollNo.compareTo(o.rollNo);
		if(rcmp != 0) return rcmp;
		
		int scmp= this.standard.compareTo(o.standard);
		if(scmp != 0) return scmp;
				
		return this.division.compareTo(o.division);
	}


}
