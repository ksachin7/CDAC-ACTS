package com.cdac.acts.book.exceptions;

@SuppressWarnings("serial")
public class BookNotFound extends Exception{
	public BookNotFound(String str) {
		super(str);
	}
}
