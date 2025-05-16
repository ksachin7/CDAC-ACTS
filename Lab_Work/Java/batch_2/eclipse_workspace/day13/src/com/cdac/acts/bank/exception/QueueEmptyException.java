package com.cdac.acts.bank.exception;

@SuppressWarnings("serial")
public class QueueEmptyException extends Exception {

	public QueueEmptyException(String str) {
		super(str);
	}
}
