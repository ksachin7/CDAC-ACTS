package com.cdac.acts.file.practice;

import java.io.*;
import java.nio.file.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        Path baseDir = Paths.get("src/com/cdac/acts/file/practice/out");
//        Path source = Path.of("src/com/cdac/acts/file.copy/out/source.txt");
        Path source = baseDir.resolve("source.txt");
        Path target = baseDir.resolve( "destination.txt");

        System.out.println(source.toAbsolutePath()+"\n"+ target.toAbsolutePath());

        // Create parent directories if needed
        Files.createDirectories(source.getParent());

        // Create the file if it doesn't exist
        if (!Files.exists(source)) {
            Files.createFile(source);
            System.out.println("✅ File created: " + source);
        }

        // Generate some sample content
        String content = """
                This is a sample file.
                Created on: %s
                Content line 1
                Content line 2
                End of sample.
                """.formatted(java.time.LocalDate.now());

        // Write content to file (create if not exists)
        Files.writeString(source, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("✅ File created and content written.");

//      Option 1: Using Files.copy() (Java NIO — Easy & Modern)
        fileCopy1(source, target);

//      Option 2: Manually copy using BufferedReader/Writer (Line by Line)
        fileCopy2(source, target);

        // Using PrintWriter to copy a file contents to another file
        fileCopy4(source, target);

//      Bonus: Using Files.readAllBytes() (Small Files)
        fileCopy3(source, target);
    }

    private static void fileCopy4(Path source, Path target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source.toFile()));
             PrintWriter pw = new PrintWriter(new FileWriter(target.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileCopy1(Path source, Path target) {
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING); // Overwrite if exists
            System.out.println("File copied successfully!");
        } catch (Exception e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    private static void fileCopy2(Path source, Path target) {
//        File source1 = new File("source.txt");
//        File dest1 = new File("destination.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(source.toFile()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(target.toFile()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Preserve line breaks
            }
            System.out.println("File copied manually!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileCopy3(Path source, Path target) {
        try {
            byte[] content = Files.readAllBytes(source);
            Files.write(target, content);
            System.out.println("Copied using readAllBytes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
