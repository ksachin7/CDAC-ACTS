package com.cdac.acts.bank;

public class CurrentAccount extends Account {
    private static final double INTEREST_RATE = 0.01;

    public CurrentAccount() {
    	super();
    }

    public CurrentAccount(String accountName, Double balance) {
        super(accountName, balance);
    }

    @Override
    public double applyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
        System.out.println("Interest applied to Current Account: " + String.format("%.2f", interest));
        return interest;
    }
}
