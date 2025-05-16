package com.cdac.acts.inheritance;

public class SmartHomeTest {
    public static void main(String[] args) {
        SmartFan fan = new SmartFan("X100", "CoolTech");

        fan.showInfo();          // from abstract class
        fan.connect();           // abstract method overridden
        fan.turnOn();            // from Switchable
        fan.configure();         // from Configurable
        fan.status();            // resolves interface default conflict
        fan.turnOff();
        Switchable.staticInfo(); // static method in interface
        System.out.println("Max power allowed: " + Switchable.MAX_POWER); // constant
    }
}
