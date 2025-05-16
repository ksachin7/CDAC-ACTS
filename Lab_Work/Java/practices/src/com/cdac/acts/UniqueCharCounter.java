package com.cdac.acts;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharCounter {
    public static void main(String[] args) {
        // Sample input string
        String input = "hello world";

        // Convert the string to a character array
        char[] chars = input.toCharArray();

        // Create a HashMap to store characters and their frequencies
        Map<Character, Integer> charCount = new HashMap<>();

        // Loop through the character array
        for (char c : chars) {
            // Check if the character is a letter (skip spaces and special characters)
            if (Character.isLetter(c)) {
                // If the character is already in the map, increment its count
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // Print the character counts
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
