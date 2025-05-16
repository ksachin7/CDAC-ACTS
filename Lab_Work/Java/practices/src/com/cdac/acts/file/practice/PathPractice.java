package com.cdac.acts.file.practice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathPractice {

	public static void main(String[] args) {

//		String fileName= "./data.dat";

        // This includes a file, not just directories
//		Path relativePath= Paths.get("src","generated", "data.log");
		Path relativePath= Paths.get("src","generated", "data.dat");
        File file= relativePath.toFile();

//        Other ways
//        Path baseDir = Paths.get("src/com/cdac/acts/file/practice/out");
//        Path file = baseDir.resolve("source.txt");
//        Path file = Path.of("src/com/cdac/acts/file.copy/out/source.txt");

        // Print the runtime class type
        System.out.println("Path type: " + relativePath.getClass().getName());
        System.out.println("File type: " + file.getClass().getName());

        // Converting Path to String
        String pathString = relativePath.toString();
        
        // Printing the Path and String representation
        System.out.println("Path object: " + relativePath);
        System.out.println("Absolute Path: " + relativePath.toAbsolutePath());
        System.out.println("Path as String: " + pathString);

		try {
            // Get the parent directory of the file
            Path dirPath = relativePath.getParent();
            
            Files.createDirectories(dirPath); // Safe – won’t throw if already exists
            
            Files.writeString(relativePath, "Hello, World!"); // overwrites if it exists
            
            // Files.deleteIfExists(filePath); // Will remove it if it exists

            System.out.println("Directories created: " + dirPath.toAbsolutePath());

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
