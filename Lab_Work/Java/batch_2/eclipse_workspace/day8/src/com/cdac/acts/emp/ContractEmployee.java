package com.cdac.acts.emp;

import java.time.LocalDate;
import java.time.Period;

public class ContractEmployee extends Employee {

	public ContractEmployee() {}

	public ContractEmployee(String name, int empno, double sal, Address address, LocalDate dob, LocalDate doj,
			Dept dept) {
		super(name, empno, sal, address, dob, doj, dept);
	}
	
	@Override
    public boolean isEligibleForGratuity() {
        return Period.between(getDoj(), LocalDate.now()).getYears() >= 5;
    }

	@Override
	public String toString() {
		return "ContractEmployee [isEligibleForGratuity()=" + isEligibleForGratuity() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}	
}
