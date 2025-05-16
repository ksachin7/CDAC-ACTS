package eclipse_workspace.day8.bank;

import java.time.LocalDate;

public class DepositeAccount extends Account{

	public DepositeAccount() {
		// TODO Auto-generated constructor stub
	}
	public DepositeAccount(String accName, LocalDate dateOfOpen, double balance, String accType) {
		super(accName, dateOfOpen, balance,  accType);
	}
	
	public double applyInterest() {
		return getBalance()*0.08;
	};

}
