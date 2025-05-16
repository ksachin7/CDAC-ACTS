package com.cdac.acts.serialize.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class BookMain {
    private static final String FILE_NAME = "src/com/cdac/acts/serialize/practiceLibrary/books.dat";

    public static void main(String[] args) {
        try {
            // Create parent directory if not exists
            Path parentDir = Paths.get(FILE_NAME).getParent();
            Files.createDirectories(parentDir);

            // Create file if not exists
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getAbsolutePath());
            } else {
                System.out.println("📁 Using existing file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Book Menu =====");
            System.out.println("1. Save a Book");
            System.out.println("2. Save Multiple Books");
            System.out.println("3. Read a Book by ISBN");
            System.out.println("4. Read All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> saveSingleBook(sc);
                case 2 -> saveMultipleBooks(sc);
                case 3 -> readBookByIsbn(sc);
                case 4 -> readBooks();
                case 5 -> {
                    System.out.println("Exiting. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    private static void saveSingleBook(Scanner sc) {
        Book book = inputBook(sc);
        List<Book> books = new ArrayList<>();
        books.add(book);
        BookHandler.saveBooks(books, FILE_NAME); // ✅ Passing String path
    }

    private static void saveMultipleBooks(Scanner sc) {
        System.out.print("How many books do you want to enter? ");
        int count = sc.nextInt();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            books.add(inputBook(sc));
        }

        BookHandler.saveBooks(books, FILE_NAME); // ✅ Passing String path
    }

    private static void readBookByIsbn(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter ISBN to search: ");
        String isbn = sc.nextLine();

        List<Book> books = BookHandler.readBooks(FILE_NAME); // ✅ Passing String path

        Book found = books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);

        if (found != null) {
            System.out.println("\n📖 Book Found:");
            System.out.println(found);
        } else {
            System.out.println("❌ No book found with ISBN: " + isbn);
        }
    }

    private static void readBooks() {
        List<Book> books = BookHandler.readBooks(FILE_NAME); // ✅ Passing String path
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\n--- Book List ---");
            books.forEach(System.out::println);
        }
    }

    private static Book inputBook(Scanner sc) {
        sc.nextLine(); // consume newline
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Book Type (e.g. Fiction, ScienceFiction): ");
        String type = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        sc.nextLine(); // consume newline
        System.out.print("Enter Publish Date (yyyy-MM-dd): ");
        String pubDate = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        return new Book(isbn, title, BookType.valueOf(type), price, LocalDate.parse(pubDate), author);
    }
}
