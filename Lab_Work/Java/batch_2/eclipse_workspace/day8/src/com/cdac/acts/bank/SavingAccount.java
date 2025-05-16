package com.cdac.acts.bank;
import java.time.LocalDate;

import com.cdac.acts.bank.Account;

public class SavingAccount extends Account {


	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	public SavingAccount(String accName, LocalDate dateOfOpen, double balance, String accType) {
		super(accName, dateOfOpen, balance,  accType);
	}
	
	public double applyInterest() {
		return getBalance()*0.08;
	};
	

}
