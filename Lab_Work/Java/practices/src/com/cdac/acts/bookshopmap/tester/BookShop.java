package com.cdac.acts.bookshopmap.tester;

import com.cdac.acts.bookshopmap.core.Book;
import com.cdac.acts.bookshopmap.exception.BookHandlingException;
import com.cdac.acts.bookshopmap.utils.CollectionUtils;
import com.cdac.acts.bookshopmap.utils.IOUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            Map<String, Book> shop = CollectionUtils.populateBooks();
            Map<String, Book> userCart = new HashMap<>();

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Book Shop Menu ---");
                System.out.println("1. Display All Books");
                System.out.println("2. Add Book to Cart");
                System.out.println("3. Show User Cart");
                System.out.println("4. Checkout and Exit");
                System.out.println("5. Load cart data from file");

                System.out.print("Choose an option: ");

                try {
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println(shop);
                            shop.values().forEach(System.out::println);
                            break;

                        case 2:
                            System.out.print("Enter Book Title: ");
                            sc.nextLine(); // consume newline
                            String title = sc.nextLine();

                            if (shop.containsKey(title)) {
                                userCart.put(title, shop.get(title));
                                System.out.println("Book added to the cart!");
                            } else {
                                throw new BookHandlingException("Book not found in the shop.");
                            }
                            break;

                        case 3:
                            if (userCart.isEmpty()) {
                                System.out.println("Cart is empty.");
                            } else {
                                userCart.values().forEach(System.out::println);
                            }
                            break;

                        case 4:
                            double total = userCart.values().stream().mapToDouble(Book::getPrice).sum();
                            System.out.println("Total Cart Value: ₹" + total);
                            System.out.println("Books Purchased:");
                            userCart.values().forEach(book -> System.out.println(book.getTitle()));
                            IOUtils.saveCartToFile(userCart, "cart.ser");
                            System.out.println("Cart saved to 'cart.ser'. Exiting...");
                            exit = true;
                            break;

                        case 5:
                            Map<String, Book> restoredCart = IOUtils.loadCartFromFile("cart.ser");
                            if (restoredCart != null) {
                                userCart.putAll(restoredCart);
                                System.out.println("Cart successfully restored:");
                                restoredCart.values().forEach(System.out::println);
                            }
                            break;

                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                } catch (BookHandlingException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e);
                    sc.nextLine(); // clean up after invalid input (if any)
                }
            }
//        sc.close();
        }
//        catch (Exception e) {
//            System.out.println("Error with Scanner resource: " + e.getMessage());
//        }
    }
}
