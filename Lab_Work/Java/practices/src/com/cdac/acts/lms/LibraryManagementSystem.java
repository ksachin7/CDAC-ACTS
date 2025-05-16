package com.cdac.acts.lms;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();

    // Add a new book to the system
    public void addBook(Book book) {
        books.add(book);
    }

    // View all books in the system
    public void viewAllBooks() {
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println("--------------");
        }
    }

    // Borrow a book (update its availability)
    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Sorry, book is not available for borrowing.");
    }

    // Return a book (update availability and calculate fine if late)
    public void returnBook(int bookId, int daysLate) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setAvailable(true);
                if (daysLate > 0) {
                    // We are casting the book object (which could be of any subclass of Book) to a FineCalculable.
                    // This is safe because we know that the actual object of book is one of the subclasses that implements the FineCalculable interface (i.e., AcademicBook, FictionBook, or NonFictionBook).
                    if (book instanceof FineCalculable) {   // to avoid ClassCastException. if you tried to cast a Book object that doesn't implement FineCalculable.
                        FineCalculable fineCalculable = (FineCalculable) book;
                        double fine = fineCalculable.calculateFine(daysLate);

                        System.out.println("Book returned: " + book.getTitle());
                        System.out.println("Fine for late return: ₹" + fine);
                    }
                } else {
                    System.out.println("Book returned on time: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();

        // Adding books to the system
        system.addBook(new AcademicBook(1, "Advanced Java", "John Doe", "Computer Science"));
        system.addBook(new FictionBook(2, "The Great Adventure", "Jane Smith", "Fantasy"));
        system.addBook(new NonFictionBook(3, "World History", "Robert Brown", "History"));

        // View all books
        system.viewAllBooks();

        // Borrow a book
        system.borrowBook(1);

        // Return a book with fine calculation
        system.returnBook(1, 5);  // Returned 5 days late
    }
}
