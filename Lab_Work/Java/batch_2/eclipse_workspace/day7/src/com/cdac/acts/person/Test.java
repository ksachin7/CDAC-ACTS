package com.cdac.acts.person;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Address addr = new Address("MG Road", "Mumbai", "Maharashtra", 400001);
        Person p = new Person("1234-5678-9012", "Ram Nath", LocalDate.of(1935, 5, 20), addr);

        System.out.println(p);
        System.out.println("Born before 15 Aug 1947? " + p.isBornBeforeIndependence());
        System.out.println("Age: " + p.calculateAge());
        System.out.println("Is age > 100? " + p.isAgeAbove100());

        System.out.println();
    }
}
