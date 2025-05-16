package com.cdac.acts.bookshop.utils;

import com.cdac.acts.bookshop.core.Book;

import java.io.*;
import java.util.List;

public class IOUtils {

    public static void saveCartToFile(List<Book> cart, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(cart);
            System.out.println("Cart contents saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> loadCartFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
