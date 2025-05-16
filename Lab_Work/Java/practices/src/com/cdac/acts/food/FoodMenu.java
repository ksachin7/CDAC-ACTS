package com.cdac.acts.food;

import java.util.Scanner;

public class FoodMenu {
    public static void main(String[] args) {
        // Initialize fixed prices for food items
        String[] menuItems = {"Dosa", "Samosa", "Idli", "Vada", "Pav Bhaji", "Puri", "Biryani", "Paneer Tikka", "Butter Chicken", "Pizza"};
        double[] prices = {50.0, 30.0, 40.0, 25.0, 60.0, 20.0, 150.0, 100.0, 200.0, 250.0}; // Fixed prices for each food item

        double totalBill = 0.0;  // To accumulate the total bill

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu to the user
            System.out.println("\nFood Menu:");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i] + " - Rs." + prices[i]);
            }
            System.out.println("10. Generate Bill & Exit");
            System.out.print("Please select an option (1-10): ");
            
            int choice = scanner.nextInt();

            // If user selects Generate Bill & Exit option (10)
            if (choice == 10) {
                System.out.println("\nGenerating your bill...");
                System.out.println("Total Bill: Rs." + totalBill);
                break;
            }

            // If user selects a valid food item (1-9)
            if (choice >= 1 && choice <= 9) {
                System.out.print("Enter the quantity of " + menuItems[choice - 1] + ": ");
                int quantity = scanner.nextInt();
                
                // Calculate the cost for this item
                double cost = prices[choice - 1] * quantity;
                totalBill += cost;
                System.out.println("Added " + quantity + " " + menuItems[choice - 1] + "(s) for Rs." + cost);
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }
}
