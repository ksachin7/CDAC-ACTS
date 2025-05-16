package com.cdac.acts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
	public static void dirOrFile(Path path) {
		if (path.endsWith(".*"))
			System.out.println("The specified path is file!");
		else
			System.out.println("The specified path is directory!");
	}

	public static void checkFileOrDirectory(String path) {
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				System.out.println("Contents of directory:");
				File[] contents = file.listFiles();
				if (contents != null) {
					for (File f : contents) {
						System.out.println(f.getName());
					}
				}
			} else {
				System.out.println("It is a file: " + file.getName());
			}
		} else {
			System.out.println("File or directory does not exist.");
		}
	}
	
    public static void copyFile(String sourcePath, String targetPath) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath));
            PrintWriter pw = new PrintWriter(writer)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {

//		String fileName= "./data.dat";
		Path fileName = Paths.get("src", "generated", "data.dat");
		File file = fileName.toFile();

//		1. Check if the file object is directory or file. If its directory then print all the files or directories in it.
		dirOrFile(fileName);
		checkFileOrDirectory(fileName.toString());

//		2. Create a new file if the file is not present at specified path
		try {
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

//		3. Read a text file using FileReader → BufferedReader
		try (FileReader fr = new FileReader(fileName.toFile())) {
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			e.printStackTrace();
		}

		// practice
		try (FileWriter fw = new FileWriter(fileName.toFile())) {
			fw.write("This is a line written using FileWriter.");
			fw.write("This is another line written using FileWriter.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName.toFile()))) {
			bw.write("This is a line written using BufferedWriter.");
			bw.newLine();
			bw.write("This is another line written using BufferedWriter.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// practice: reading file data using BufferedReader
		try (BufferedReader br = new BufferedReader(new FileReader(fileName.toFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		// practice: Using PrintWriter to Write to file
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
		
//		4. Read from one text file and write in other files(Copy). 
//		Use PrintWriter, Bufferedwriter, FileWriter for writing. 
//		User BufferedReader, FileReader for reading. Use try catch with resource
		String sourceFile= Paths.get("src", "generated","data.dat").toString();
		String targetFile= Paths.get("src", "generated","CopiedFile.dat").toString();
		
		copyFile(sourceFile, targetFile);

	}
}
