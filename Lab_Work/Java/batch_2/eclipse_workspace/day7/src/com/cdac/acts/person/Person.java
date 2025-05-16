package com.cdac.acts.person;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String aadhaarNumber;
    private String name;
    private LocalDate dob;
    private Address address;

    public Person(String aadhaarNumber, String name, LocalDate dob, Address address) {
        this.aadhaarNumber = aadhaarNumber;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public boolean isBornBeforeIndependence() {
        LocalDate independenceDate = LocalDate.of(1947, 8, 15);
        return dob.isBefore(independenceDate);
    }

    public int calculateAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public boolean isAgeAbove100() {
        return calculateAge() > 100;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Aadhaar: " + aadhaarNumber +
                ", DOB: " + dob +
                ", Address: " + address;
    }

    public LocalDate getDob() {
        return dob;
    }
}
