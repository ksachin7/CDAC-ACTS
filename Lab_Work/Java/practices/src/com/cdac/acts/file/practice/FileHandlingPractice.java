package com.cdac.acts.file.practice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandlingPractice {

    public static void main(String[] args) {
//		String fileName= "./data.dat";
        Path fileName = Paths.get("src", "generated", "data.txt");
        File file = fileName.toFile();

        Path targetFilePath = Paths.get("src", "generated", "CopiedFile.log");
        File targetFile = null;

        // Create a new file if not present
        try {
            // Ensure parent directories exist
            Files.createDirectories(targetFilePath.getParent());

            targetFile = targetFilePath.toFile();

            // Create file only if it doesn't exist
            if (targetFile.createNewFile()) {
                System.out.println("✅ File created: " + targetFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check if the file object is directory or file.
        // If its directory then print all the files or directories in it.
        try {
            if (file.isDirectory()) {
                System.out.println(fileName + " is a directory.");
                String[] files = file.list();
                if (files != null) {
                    for (String f : files) {
                        System.out.println(f);
                    }
                }
            } else if (file.isFile()) {
                System.out.println(fileName + " is a file.");
            } else {
                System.out.println(fileName + " does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // reading file data using FileReader
        try (FileReader fr = new FileReader(fileName.toFile())) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(fileName.toFile())) {
            fw.write("This is a line written using FileWriter.");
            fw.write("This is another line written using FileWriter.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // writing using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName.toFile()))) {
            bw.write("This is a line written using BufferedWriter.");
            bw.newLine();
            bw.write("This is another line written using BufferedWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reading file data using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        // Using PrintWriter to Write to file
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName.toFile(), false))) {
            pw.write("This is a line written using PrintWriter.");
            pw.write("Hello, World!");
            pw.write("This is a text file.");
//			System.out.println((pw.getClass()));
//			System.out.println(pw.toString());
            pw.printf("Number: %d", 42);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Using PrintWriter to copy a file contents to another file
        System.out.println("Reading from: " + targetFile.getAbsolutePath());
        System.out.println("Target exists? " + targetFile.exists());

        try (PrintWriter pw = new PrintWriter(new FileWriter(targetFile));
             BufferedReader br = new BufferedReader(new FileReader(fileName.toFile()))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(line);
                pw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // using newBufferedReader with Path without converting to String
        try (BufferedReader reader = Files.newBufferedReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(fileName)) {
            writer.write("Using newBufferedReader with Path without converting Path to String");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // printing file content using scanner
        try (Scanner sc = new Scanner(new FileReader(file))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
