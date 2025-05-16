package com.cdac.acts.bank.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	
	public AccountNotFoundException(String msg) {
		super(msg);
	}

}
