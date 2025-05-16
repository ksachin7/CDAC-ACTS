package eclipse_workspace.day4;

import java.util.Scanner;

public class NumberToWords {

    private static final String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] thousands = {"", "thousand", "lakh", "crore"};

       // Convert the number to words
    public static String numberToWords(long number) {
        if (number == 0) {
            return "zero";
        }

        String result = "";
        int i = 0; // Position counter for thousands (e.g., thousand, lakh, crore)
        if (number % 1000 != 0) {
                result = convertHundreds(number % 1000) + " " + thousands[i] + " " + result;
        }
        number /= 1000;
        i++;

        while (number > 0) {
            if (number % 1000 != 0) {
                result = convertHundreds(number % 100) + " " + thousands[i] + " " + result;
            }
            number /= 100;
            i++;
        }

        return result.trim().replaceAll("\\s{2,}", " "); // Replace multiple spaces with a single space
    }

    // Convert hundreds, tens, and ones into words
    public static String convertHundreds(long number) {
        String result = "";

        if (number >= 100) {
            result += ones[(int) (number / 100)] + " hundred ";
            number %= 100;
        }

        if (number >= 20) {
            result += tens[(int) (number / 10)] + " ";
            number %= 10;
        }

        if (number > 0) {
            result += ones[(int) number] + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        // int number = 123456789;
        // System.out.println(number + ": " + numberToWords(number));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        System.out.println(numberToWords(number));

    }
}
