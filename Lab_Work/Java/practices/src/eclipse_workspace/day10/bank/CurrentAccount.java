package eclipse_workspace.day10.bank;

public class CurrentAccount extends Account {
    private static final double INTEREST_RATE = 0.01;

    public CurrentAccount() {}

    public CurrentAccount(String accountName) {
        super(accountName);
    }

    @Override
    public double applyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
        System.out.println("Interest applied to Current Account: " + String.format("%.2f", interest));
        return interest;
    }
}
