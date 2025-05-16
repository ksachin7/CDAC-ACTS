package com.cdac.acts.bookshopmap.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    // adding a version number or using serialVersionUID inside the Book class, to avoid compatibility issues when deserializing across versions of the application.
    private String title;
    private String author;
    private double price;
    private Category category;
    private LocalDate publishDate;

    public enum Category {
        FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY
    }

    public Book(String title, String author, double price, Category category, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Author: %s | Price: %.2f | Category: %s | Publish Date: %s",
                title, author, price, category, publishDate);
    }
}
