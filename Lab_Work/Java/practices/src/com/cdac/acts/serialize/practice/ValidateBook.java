package com.cdac.acts.serialize.practice;

public class ValidateBook {
    public static boolean isValid(Book book) {
        return book.getIsbn() != null && !book.getIsbn().isBlank()
                && book.getTitle() != null && !book.getTitle().isBlank()
                && book.getAuthor() != null && !book.getAuthor().isBlank()
                && book.getBtype() != null
                && book.getPrice() >= 0;
    }
}