package com.cdac.acts.bank;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount() {}

    public SavingsAccount(String accountName) {
        super(accountName);
    }

    @Override
    public double applyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
        System.out.println("Interest applied to Saving Account: " + String.format("%.2f", interest));
        return interest;
    }
}
