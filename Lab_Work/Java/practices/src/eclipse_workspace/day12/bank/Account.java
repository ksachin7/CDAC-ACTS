package eclipse_workspace.day12.bank;

import java.time.LocalDate;

public class Account {
	private Integer accNo;
    private String accName;
	private LocalDate dateOfOpening;
	private Double balance;

	public Account() {}

	public Account(int accNo, String accName, LocalDate dateOfOpening, double balance) {
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccName() {
		return accName;
	}

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public LocalDate getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(LocalDate dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
}
