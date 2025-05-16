package eclipse_workspace.day11.bank;

import java.time.LocalDate;

public class Account {
	private int accNo;
    private String accName;
	private LocalDate dateOfOpening;
	private double balance;

	public Account() {}

	public Account(int accNo, String accName, LocalDate dateOfOpening, double balance) {
		if(balance <= 1000)
			throw new IllegalArgumentException("Balance must be greater than 1000.");
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

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccName() {
		return accName;
	}
}
