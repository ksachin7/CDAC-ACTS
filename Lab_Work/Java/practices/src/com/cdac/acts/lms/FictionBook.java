package com.cdac.acts.lms;

public class FictionBook extends Book implements FineCalculable {
    private String genre;

    // Constructor
    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    // Override displayBookDetails to include genre information
    @Override
    public void displayBookDetails() {
        super.displayBookDetails();
        System.out.println("Genre: " + genre);
    }

    // Implement calculateFine to calculate the fine for fiction books
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 3;  // ₹3 per day
    }
}
