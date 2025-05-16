package com.cdac.acts.serialize.practice;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private static final long serialVersionUID = 5595140229690747468L;
    private String isbn;
    private String title;
    private BookType btype;
    private Double price;
    private LocalDate pubDate;
    private String author;

//    transient private Boolean isValid;

    public Book(String isbn, String title, BookType btype, Double price, LocalDate pubDate, String author) {
        this.isbn = isbn;
        this.title = title;
        this.btype = btype;
        this.price = price;
        this.pubDate = pubDate;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", btype=" + btype + ", price=" + price + ", pubDate="
                + pubDate + ", author=" + author + "]";
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public BookType getBtype() {
        return btype;
    }


    public void setBtype(BookType btype) {
        this.btype = btype;
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    public LocalDate getPubDate() {
        return pubDate;
    }


    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}