package com.cdac.acts.emp;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private int empno;
    private double sal;
    private Address address;
    private LocalDate dob;
    private LocalDate doj;
    private Dept dept;

    public Employee() {}

//    public Employee(String name, int empno, double sal, String street, String city, String state, String country,
//                    int pincode, LocalDate dob, LocalDate doj, Dept dept) {
//        this.name = name;
//        this.empno = empno;
//        this.sal = sal;
//        this.address = new Address(street, city, state, country, pincode);
//        this.dob = dob;
//        this.doj = doj;
//        this.dept = dept;
//    }
    public Employee(String name, int empno, double sal, Address address, LocalDate dob, LocalDate doj, Dept dept) {
        this.name = name;
        this.empno = empno;
        this.sal = sal;
        this.address = address;
        this.dob = dob;
        this.doj = doj;
        this.dept = dept;
    }

    public boolean isEligibleForGratuity() {
        return Period.between(doj, LocalDate.now()).getYears() >= 5;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name +
                ", empno=" + empno +
                ", sal=" + sal +
                ", dob=" + dob +
                ", doj=" + doj +
                ", dept=" + dept +
                ", address=" + address + "]";
    }
}
