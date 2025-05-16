package com.cdac.acts.bank;

public class FixedDepositAccount extends Account implements Maturable {
    private static final double INTREST_RATE= 0.08;
    private int tenureYears= 5;

    public FixedDepositAccount() {}

    public FixedDepositAccount(String accountName, Double balance) {
        super(accountName, balance);
    }

    @Override
    public double applyInterest() {
        double interest= getBalance()* INTREST_RATE * tenureYears;
        deposit(interest);
        System.out.println("Interest applied to FD Account: " + String.format("%.2f", interest));
        return interest;
    }

    @Override
    public double calculateMaturityAmount() {
        return getBalance() + (getBalance() *  applyInterest());
    }

    public int getTenureYears() {
        return tenureYears;
    }

    public void setTenureYears(int tenureYears) {
        this.tenureYears = tenureYears;
    }
}
