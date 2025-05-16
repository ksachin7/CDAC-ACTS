package com.cdac.acts.booktester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cdac.acts.book.exceptions.BookNotFound;
import com.cdac.acts.book.exceptions.DuplicateBook;
import com.cdac.acts.books.Book;
import com.cdac.acts.books.BookType;

public class BookHashMapTester {
	private static Map<String,Book> bookMap = new HashMap<>();
	
	private static Book findByTitle(String title) throws BookNotFound{
		if(bookMap.get(title) != null) {
			return bookMap.get(title);
		}
		else {
			throw new BookNotFound("Book is Not Found in Liberary!!");
		}
	}

	public static void main(String[] args) {
		
		
		try(Scanner sc = new Scanner(System.in)){
			while(true) {
				System.out.println(""
						+ "1. Add book.\n"
						+ "2.Display All books\n"
						+ "3.Allot book to student\n"
						+ "4.Take book return\n"
						+ "5.Remove book\n"
						+ "6.Exit\n"
						+ "");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:{
//					bookMap.put("title", new Book( "title", BookType.Fantasy, 500.00, LocalDate.now(), "author",3));
//					bookMap.put("title2", new Book( "title2", BookType.Horror, 400.00, LocalDate.now(), "author2",4));
//					bookMap.put("title3", new Book( "title3", BookType.Mystery, 300.00, LocalDate.now(), "author3",5));
					System.out.println("Enter Book title:");
					String title = sc.next();
					
					System.out.println("Enter Book type from followings\n"
							+ "Fantasy,\n"
							+ "Horror,\n"
							+ "ScienceFiction,\n"
							+ "Mystery,\n"
							+ "Thriler,\n"
							+ "Adventure");
					String bType = sc.next();
					
					
					System.out.println("Enter Book price:");
					Double price = sc.nextDouble();
					
					System.out.println("Enter Book publish Date in yyyy-mm-dd");
					String date = sc.next();
					LocalDate pDate = LocalDate.parse(date);
					
					System.out.println("Enter Book author Name:");
					String author = sc.next();
					
					System.out.println("Enter Book Quantity:");
					Integer qty = sc.nextInt();
					
					if(!bookMap.containsKey(title)) {
						bookMap.put(title,new Book( title, BookType.valueOf(bType),  price,  pDate,  author,  qty));
					}
					else {
						throw new DuplicateBook("Book is Already Present!!");
					}
			
					break;
					
				}
				case 2:{
					for(Map.Entry<String,Book> entry:bookMap.entrySet()) {
						System.out.println(entry.getValue());
					}
					break;
				}
				case 3:{
					System.out.println("Enter Title of Book want to Take :");
					String title = sc.next();
					Book book = findByTitle(title);
					book.setQty(book.getQty()-1);
					System.out.println("Book Alloted");
					break;
					
				}
				case 4:{
					System.out.println("Enter Title of Book you want to Return :");
					String title = sc.next();
					Book book = findByTitle(title);
					book.setQty(book.getQty()+1);
					System.out.println("Book Returned Succesfully");
					break;
					
				}
				case 5:{
					System.out.println("Enter Title of Book you want to Return :");
					String title = sc.next();
					bookMap.remove(title);
				}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
