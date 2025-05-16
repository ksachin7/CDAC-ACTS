package com.cdac.acts.bookshop.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    private String title;
    private String author;
    private double price;
    private Category category;
    private LocalDate publishDate;

    // Constructor
    public Book(String title, String author, double price, Category category, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.publishDate = publishDate;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    // To display book details
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nCategory: " + category + "\nPublish Date: " + publishDate;
    }
}
