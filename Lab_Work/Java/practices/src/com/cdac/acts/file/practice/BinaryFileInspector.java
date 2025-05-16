package com.cdac.acts.file.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryFileInspector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get file path from user
        System.out.print("Enter path to a binary file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        // 2. Check if file exists
        if (!file.exists() || !file.isFile()) {
            System.out.println("❌ File does not exist or is not a valid file.");
            return;
        }

        // 3. Read binary data
        readBinaryData(file);

        // 4. Read and print as characters
        readCharData(file);

    }

    private static void readCharData(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println("reaading "+ file + " date: ");
            int b;
            while ((b = fis.read()) != -1) {
                // Only print printable characters, else use '.'
                if (b >= 32 && b <= 126) {
                    System.out.print((char) b);
                } else if (b == 10 || b == 13) {
                    System.out.print((char) b); // Allow newlines and carriage return
                } else {
                    System.out.print("#"); // Non-printable character
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    }

    private static void readBinaryData(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            int byteData;
            int count = 0;
            System.out.println("\n🔍 Binary content of file (in decimal & hex):");

            while ((byteData = fis.read()) != -1) {
                System.out.printf("%03d (0x%02X)  ", byteData, byteData);
                count++;

                // Print 8 bytes per line for readability
                if (count % 8 == 0) System.out.println();
            }

            if (count == 0) {
                System.out.println("⚠️ File is empty.");
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    }
}
