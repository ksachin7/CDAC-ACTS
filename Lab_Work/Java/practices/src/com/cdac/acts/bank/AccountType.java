package com.cdac.acts.bank;

public enum AccountType {
//    SAVINGS(4.0, "General Savings Account"),
//    CURRENT(0.0, "No interest, for businesses"),
//    FIXED_DEPOSIT(6.5, "Locked amount with high interest");
    SAVINGS(4.0, "Savings Account"),
    CURRENT(0.0, "Current Account"),
    FIXED_DEPOSIT(6.5, "Fixed Deposit Account");


    private final double interestRate;
    private final String description;

    AccountType(double interestRate, String description) {
        this.interestRate = interestRate;
        this.description = description;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getDescription() {
        return description;
    }
}
