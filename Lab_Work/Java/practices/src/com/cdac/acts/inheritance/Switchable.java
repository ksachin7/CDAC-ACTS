package com.cdac.acts.inheritance;

// Interface 1
interface Switchable {
    int MAX_POWER = 100; // public static final

    void turnOn();       // public abstract
    void turnOff();

    default void status() {
        System.out.println("Device is in default state.");
    }

    static void staticInfo() {
        System.out.println("Switchable device interface - static info.");
    }
}

// Interface 2
interface Configurable {
    void configure();

    default void status() {
        System.out.println("Device is configurable.");
    }
}

// Abstract class
abstract class SmartDevice {
    private String model;
    private String brand;

    public SmartDevice(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public void showInfo() {
        System.out.println("Model: " + model + ", Brand: " + brand);
    }

    public abstract void connect(); // Must be implemented
}

// Concrete class
class SmartFan extends SmartDevice implements Switchable, Configurable {

    public SmartFan(String model, String brand) {
        super(model, brand);
    }

    @Override
    public void connect() {
        System.out.println("Connecting SmartFan to Wi-Fi...");
    }

    @Override
    public void turnOn() {
        System.out.println("SmartFan is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartFan is turned OFF.");
    }

    @Override
    public void configure() {
        System.out.println("Configuring SmartFan...");
    }

    // Resolving default method conflict between Switchable and Configurable
    @Override
    public void status() {
        // You can call a specific interface default method like this:
        Switchable.super.status();
        Configurable.super.status();
        System.out.println("SmartFan status override.");
    }
}