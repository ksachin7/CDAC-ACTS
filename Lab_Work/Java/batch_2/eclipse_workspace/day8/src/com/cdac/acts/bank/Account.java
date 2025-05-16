package com.cdac.acts.bank;
import java.time.LocalDate;

public abstract class Account {
	
	private static int count=100;
	private String accName;
	private String accType;
	private int accNo;
	private LocalDate dateOfOpen;
	private double balance;
	

	public Account() {
		
	}

	public Account(String accName, LocalDate dateOfOpen, double balance,String accType) {
		this.accName = accName;
		this.accNo = count++;
		this.dateOfOpen = dateOfOpen;
		this.balance = balance;
		this.accType=accType;
	}
	public abstract double applyInterest() ;


	@Override
	public String toString() {
		return "Account [accName=" + accName + ", accType=" + accType + ", accNo=" + accNo + ", dateOfOpen="
				+ dateOfOpen + ", balance=" + balance + "]";
	}

	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		Account.count = count;
	}


	public String getAccName() {
		return accName;
	}


	public void setAccName(String accName) {
		this.accName = accName;
	}


	public int getAccNo() {
		return accNo;
	}


	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}


	public LocalDate getDateOfOpen() {
		return dateOfOpen;
	}


	public void setDateOfOpen(LocalDate dateOfOpen) {
		this.dateOfOpen = dateOfOpen;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
