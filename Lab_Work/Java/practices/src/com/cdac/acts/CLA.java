package com.cdac.acts;

class CLA {
    public static void main(String[] args) {
        // Ensure there are enough arguments
        if (args.length < 5) {
            System.out.println("Please enter at least 5 arguments!");
            return;
        }

        try {
            // Parse each argument into its respective type
            int num1 = Integer.parseInt(args[0]);  // Integer
            float num2 = Float.parseFloat(args[1]);  // Float
            double num3 = Double.parseDouble(args[2]);  // Double
            long num4 = Long.parseLong(args[3]);  // Long
            char c = args[4].charAt(0);  // Char (Assuming single character)
            boolean bool = Boolean.parseBoolean(args[5]);  // Boolean

            // Output the parsed values
            System.out.println("Integer: " + num1);
            System.out.println("Float: " + num2);
            System.out.println("Double: " + num3);
            System.out.println("Long: " + num4);
            System.out.println("Char: " + c);
            System.out.println("Boolean: " + bool);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please ensure all arguments are in the correct format.");
        }
    }
}
