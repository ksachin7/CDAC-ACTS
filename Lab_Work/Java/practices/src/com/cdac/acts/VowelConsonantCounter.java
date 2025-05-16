package com.cdac.acts;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Initialize variables to count vowels and consonants
        int vowelCount = 0;
        int consonantCount = 0;

        // Convert the input to lowercase to handle case insensitivity
        input = input.toLowerCase();

        // Loop through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(ch)) {
                // Check if the character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                }
                // Otherwise, it is a consonant
                else {
                    consonantCount++;
                }
            }
        }

        // Display the result
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);

        // Close the scanner
        scanner.close();
    }
}
