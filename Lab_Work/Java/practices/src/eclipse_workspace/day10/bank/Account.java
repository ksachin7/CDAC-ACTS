package eclipse_workspace.day10.bank;

import eclipse_workspace.day10.bank.exception.MinBalException;
import java.time.LocalDate;
import java.util.Random;

public abstract class Account implements Depositable, Withdrawable{
    private String accountNumber;
    private String accountName;
    private LocalDate dateOfOpening;
    private double balance;

    public Account() {}

    public Account(String accountName) {
        this.accountNumber = generateAccountNumber();
        this.accountName = accountName;
        this.dateOfOpening = LocalDate.now();
        this.balance = 0.0;
    }

    private String generateAccountNumber(){
        Random random= new Random();
        return String.format("%010d", random.nextInt(1000000000));
    }

    public double deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + ". Current balance: " + this.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
        return  this.balance;
    }

    public double withdraw(double amount) throws MinBalException {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Current balance: " + this.balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            throw new MinBalException("Insufficient balance.");
        }
        return  this.balance;
    }

    public abstract double applyInterest();

//    @Override
//    public double calculateMaturityAmount(double interestRate) {
//        // Example: Simple Interest for 1 year
//        double maturityAmount = balance + (balance * interestRate);
//        System.out.println("Maturity Amount: " + maturityAmount);
//        return maturityAmount;
//    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", dateOfOpening=" + dateOfOpening +
                ", balance=" + balance +
                '}';
    }
}
