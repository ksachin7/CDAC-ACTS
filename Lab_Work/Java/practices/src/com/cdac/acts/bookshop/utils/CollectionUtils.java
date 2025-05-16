package com.cdac.acts.bookshop.utils;

import com.cdac.acts.bookshop.core.Book;
import com.cdac.acts.bookshop.exception.BookNotFoundException;

import java.util.List;

public class CollectionUtils {

    public static boolean addToCart(List<Book> cart, String bookTitle, List<Book> bookList) throws BookNotFoundException {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                cart.add(book);
                return true;
            }
        }
        throw new BookNotFoundException("Book with title '" + bookTitle + "' not found in the shop.");
    }

    public static void displayBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
            System.out.println("---------------");
        }
    }

    public static void displayCart(List<Book> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Book book : cart) {
                System.out.println(book);
                System.out.println("---------------");
            }
        }
    }
}
