package com.cdac.acts.bookshop.tester;

import com.cdac.acts.bookshop.core.Book;
import com.cdac.acts.bookshop.core.Category;
import com.cdac.acts.bookshop.exception.BookNotFoundException;
import com.cdac.acts.bookshop.utils.CollectionUtils;
import com.cdac.acts.bookshop.utils.IOUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        List<Book> cart = new ArrayList<>();
        
        // Add sample books to the shop
        bookList.add(new Book("Java Basics", "John Doe", 29.99, Category.SCIENCE, LocalDate.parse("2023-03-15")));
        bookList.add(new Book("Advanced Java", "Jane Smith", 39.99, Category.SCIENCE, LocalDate.of(2024, 5, 10)));
        bookList.add(new Book("Fictional Tales", "Tom Riddle", 19.99, Category.FICTION, LocalDate.of(2020, 7, 25)));
        bookList.add(new Book("History of the World", "Mark Twain", 25.99, Category.HISTORY, LocalDate.of(2019, 2, 5)));
        bookList.add(new Book("Science 101", "Albert Einstein", 15.99, Category.SCIENCE, LocalDate.of(2021, 6, 11)));

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display all books from the shop.");
            System.out.println("2. Add Book to The Cart.");
            System.out.println("3. Show User Cart Contents.");
            System.out.println("4. Check out.");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    CollectionUtils.displayBooks(bookList);
                    break;
                case 2:
                    System.out.print("Enter Book Title to add to the cart: ");
                    String title = scanner.nextLine();
                    try {
                        if (CollectionUtils.addToCart(cart, title, bookList)) {
                            System.out.println("Book added to the cart.");
                        }
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    CollectionUtils.displayCart(cart);
                    break;
                case 4:
                    double total = 0;
                    System.out.println("\nBooks in your cart:");
                    for (Book book : cart) {
                        total += book.getPrice();
                        System.out.println(book.getTitle());
                    }
                    System.out.println("\nTotal Cart Value: $" + total);
                    IOUtils.saveCartToFile(cart, "cart.dat");
                    System.out.println("Thank you for shopping!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
