package com.cdac.acts.day9.Tester;

import com.cdac.acts.day9.Shape.Circle;
import com.cdac.acts.day9.Shape.Rectangle;
import com.cdac.acts.day9.Shape.Drawable;

import java.util.Scanner;

public class ShapeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Drawable drawable = null;

        int choice;
        do {
            System.out.println("1. Draw Circle");
            System.out.println("2. Draw Rectangle");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    drawable = new Circle();
                    drawable.draw();
                    break;

                case 2:
                    drawable = new Rectangle();
                    drawable.draw();
                    break;

                case 0:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 0);

        scanner.close();
    }
}
