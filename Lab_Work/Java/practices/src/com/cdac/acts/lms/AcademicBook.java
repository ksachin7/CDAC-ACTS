package com.cdac.acts.lms;

public class AcademicBook extends Book implements FineCalculable {
    private String subject;

    // Constructor
    public AcademicBook(int bookId, String title, String author, String subject) {
        super(bookId, title, author);
        this.subject = subject;
    }

    // Override displayBookDetails to include subject information
    @Override
    public void displayBookDetails() {
        super.displayBookDetails();
        System.out.println("Subject: " + subject);
    }

    // Implement calculateFine to calculate the fine for academic books
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 5;  // ₹5 per day
    }
}
