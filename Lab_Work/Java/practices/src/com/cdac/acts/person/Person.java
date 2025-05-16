package com.cdac.acts.person;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private Date birthDate;
    private PersonAddress address;

    public Person(String name, Date birthDate, PersonAddress address) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() { return name; }
    public Date getBirthDate() { return birthDate; }
    public PersonAddress getAddress() { return address; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Name: " + name + ", DOB: " + sdf.format(birthDate) + ", Address: " + address;
    }
}
