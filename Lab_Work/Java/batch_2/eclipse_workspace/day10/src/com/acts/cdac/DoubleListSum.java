package com.acts.cdac;

import java.util.ArrayList;
import java.util.Scanner;

public class DoubleListSum {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        // Accept 10 double values using do-while
        do {
            System.out.print("Enter number " + (count + 1) + ": ");
            double num = scanner.nextDouble();
            numbers.add(num);
            count++;
        } while (count < 10);

        // Calculate sum
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        // Print the sum
        System.out.println("\nThe sum of all numbers is: " + sum);

        scanner.close();
    }
}
