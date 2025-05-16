package com.cdac.acts.bank;

import java.time.LocalDate;

public class Account {
	private int accNo;
    private String accName;
	private LocalDate dateOfOpening;
	private double balance;
	
	
	public Account(int accNo, String accName, LocalDate dateOfOpening, double balance) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.dateOfOpening = dateOfOpening;
		this.balance = balance;
	}

	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", dateOfOpening=" + dateOfOpening + ", balance="
				+ balance + "]";
	}

	public int getAccNo() {
		return accNo;
	}


	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}


	public String getAccName() {
		return accName;
	}


	public void setAccName(String accName) {
		this.accName = accName;
	}


	public LocalDate getDateOfOpening() {
		return dateOfOpening;
	}


	public void setDateOfOpening(LocalDate dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
