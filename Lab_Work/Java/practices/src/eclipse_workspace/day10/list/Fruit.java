package com.acts.cdac;

import java.util.ArrayList;
import java.util.Scanner;

class Fruit {
    String name;
    String color;
    double price;
    int quantity;

    public Fruit(String name, String color, double price, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{name='" + name + "', color='" + color + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

// Main class to test functionality
class FruitManager {
    public static void main(String[] args) {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding some fruits
        fruitList.add(new Fruit("Apple", "Red", 1.2, 10));
        fruitList.add(new Fruit("Banana", "Yellow", 0.5, 20));
        fruitList.add(new Fruit("Orange", "Orange", 0.8, 15));

        // Display fruits
        System.out.println("Current fruit list:");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(i + ": " + fruitList.get(i));
        }

        System.out.println("\nAdd a new fruit:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        fruitList.add(new Fruit(name, color, price, quantity));
        System.out.println("Fruit added!");

        // Display updated list
        System.out.println("\nUpdated fruit list:");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(i + ": " + fruitList.get(i));
        }

        // Remove fruit by index
        System.out.print("\nEnter index of fruit to remove: ");
        int indexToRemove = scanner.nextInt();
        if (indexToRemove >= 0 && indexToRemove < fruitList.size()) {
            fruitList.remove(indexToRemove);
            System.out.println("Fruit removed.");
        } else {
            System.out.println("Invalid index!");
        }

        // Final list
        System.out.println("\nFinal fruit list:");
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(i + ": " + fruitList.get(i));
        }

        scanner.close();
    }
}