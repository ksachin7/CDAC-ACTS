package com.cdac.acts.books;

import java.time.LocalDate;

public class Book {
	private String title;
	private BookType btype;
	private Double price;
	private LocalDate pubDate;
	private String author;
	private Integer qty;
	

	public Integer getQty() {
		return qty;
	}



	public void setQty(Integer qty) {
		this.qty = qty;
	}



	public Book(String title, BookType btype, Double price, LocalDate pubDate, String author, Integer qty) {
		this.title = title;
		this.btype = btype;
		this.price = price;
		this.pubDate = pubDate;
		this.author = author;
		this.qty = qty;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", btype=" + btype + ", price=" + price + ", pubDate=" + pubDate + ", author="
				+ author + ", qty=" + qty + "]";
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
	
	

}
