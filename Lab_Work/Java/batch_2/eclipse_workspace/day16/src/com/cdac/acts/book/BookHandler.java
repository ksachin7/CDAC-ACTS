package com.cdac.acts.book;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookHandler {
    public static void saveBook(Book book, DataOutputStream dos) throws IOException {
        if (!BookValidator.isValid(book)) {
            System.out.println("Invalid book not saved: " + book);
            return;
        }
        dos.writeUTF(book.getIsbn());
        dos.writeUTF(book.getTitle());
        dos.writeUTF(book.getBtype().name());
        dos.writeDouble(book.getPrice());
        dos.writeUTF(book.getPubDate().toString());
        dos.writeUTF(book.getAuthor());
    }

    public static void saveBooks(List<Book> books, String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Book book : books) {
                saveBook(book, dos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book readBook(DataInputStream dis) throws IOException {
        String isbn= dis.readUTF();
        String title = dis.readUTF();
        String btypeStr = dis.readUTF();
        double price = dis.readDouble();
        String pubDateStr = dis.readUTF();
        String author = dis.readUTF();

        // Convert String to Enum and LocalDate
        BookType btype = BookType.valueOf(btypeStr);         // Convert String to Enum
        LocalDate pubDate = LocalDate.parse(pubDateStr);     // Convert String to LocalDate

        return new Book(isbn, title, btype, price, pubDate, author);  // isValid is recalculated in constructor
    }

    public static List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                books.add(readBook(dis));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}