package com.cdac.acts.person;

import java.io.Serializable;

public class PersonAddress implements Serializable {
    private String area;
    private String district;
    private int pin;

    public PersonAddress(String area, String district, int pin) {
        this.area = area;
        this.district = district;
        this.pin = pin;
    }

    public String getArea() { return area; }
    public String getDistrict() { return district; }
    public int getPin() { return pin; }

    @Override
    public String toString() {
        return area + ", " + district + " - " + pin;
    }
}
