package com.cdac.acts.bookshopmap.utils;

import com.cdac.acts.bookshopmap.core.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class IOUtils {
    public static void saveCartToFile(Map<String, Book> cart, String fileName) {
        try {
            // Ensure directory exists
            Path directoryPath = Paths.get("src", "cartData");
            Files.createDirectories(directoryPath); // creates if it doesn't exist

            File file = directoryPath.resolve(fileName).toFile();

            // ObjectOutputStream is used here to serialize the entire cart
            // FileOutputStream automatically creates the file if it doesn't exist
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(cart);

                // No need to flush or close explicitly — handled by try-with-resources
                // oos.close();    // flushes and closes the stream.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Book> loadCartFromFile(String fileName) {
        Path filePath = Paths.get("src", "cartData", fileName);
        File file = filePath.toFile();

        if (!file.exists() || !file.canRead()) {
            System.err.println("File not found or not readable: " + file.getAbsolutePath());
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                return (Map<String, Book>) obj;
            } else {
                System.err.println("Invalid file format: Expected a Map<String, Book>.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading cart: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
