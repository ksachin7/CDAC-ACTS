package eclipse_workspace.day8.bank;
import java.time.LocalDate;

public class SavingAccount extends Account {


	public SavingAccount() {
        super();
	}
	public SavingAccount(String accName, LocalDate dateOfOpen, double balance, String accType) {
		super(accName, dateOfOpen, balance,  accType);
	}
	
	public double applyInterest() {
		return getBalance()*0.08;
	};
	

}
