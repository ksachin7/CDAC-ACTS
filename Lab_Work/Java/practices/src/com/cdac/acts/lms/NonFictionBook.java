package com.cdac.acts.lms;

public class NonFictionBook extends Book implements FineCalculable {
    private String topic;

    // Constructor
    public NonFictionBook(int bookId, String title, String author, String topic) {
        super(bookId, title, author);
        this.topic = topic;
    }

    // Override displayBookDetails to include topic information
    @Override
    public void displayBookDetails() {
        super.displayBookDetails();
        System.out.println("Topic: " + topic);
    }

    // Implement calculateFine to calculate the fine for non-fiction books
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 4;  // ₹4 per day
    }
}
