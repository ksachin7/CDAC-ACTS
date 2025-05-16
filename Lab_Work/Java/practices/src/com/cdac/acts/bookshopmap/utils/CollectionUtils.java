package com.cdac.acts.bookshopmap.utils;

import com.cdac.acts.bookshopmap.core.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CollectionUtils {
    public static Map<String, Book> populateBooks() {
        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("Java101", new Book("Java101", "James Gosling", 500.0, Book.Category.TECHNOLOGY, LocalDate.of(2020, 5, 20)));
        bookMap.put("Java101", new Book("Java10", "James Gosling", 500.0, Book.Category.TECHNOLOGY, LocalDate.of(2020, 5, 20)));
        bookMap.put("dupJava101", new Book("Java101", "James Gosling", 500.0, Book.Category.TECHNOLOGY, LocalDate.of(2020, 5, 20)));
        bookMap.put("SciFiX", new Book("SciFiX", "Isaac Asimov", 300.0, Book.Category.FICTION, LocalDate.of(2015, 3, 15)));
        bookMap.put("HistoryOfWorld", new Book("HistoryOfWorld", "Yuval Harari", 450.0, Book.Category.HISTORY, LocalDate.of(2018, 9, 10)));
        bookMap.put("BioLife", new Book("BioLife", "Jane Doe", 280.0, Book.Category.SCIENCE, LocalDate.of(2022, 1, 5)));
        bookMap.put("ThinkBig", new Book("ThinkBig", "Ben Carson", 320.0, Book.Category.NON_FICTION, LocalDate.of(2017, 6, 30)));
        return bookMap;
    }

    public static void addNewBook(){

    }
}
