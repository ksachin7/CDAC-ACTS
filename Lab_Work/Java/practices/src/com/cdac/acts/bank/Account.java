package com.cdac.acts.bank;

import com.cdac.acts.bank.exception.AccountNotFoundException;
import com.cdac.acts.bank.exception.InsufficientBalanceException;
import com.cdac.acts.bank.exception.InvalidAccountException;
import com.cdac.acts.bank.service.BankService;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

public class Account extends BankService implements Serializable, Comparable<Account>, Taxable {
    private static final long serialVersionUID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    private static int idCounter = 1000;

    private int id;
    private String accountNumber;
    private AccountHolder holder;
    private double balance;
    private AccountType accountType;

    private LocalDate creationDate;
    private LocalDate updateDate;
    private LocalDate deletionDate;

    private transient String password;

    public Account(AccountHolder holder, double balance, AccountType accountType, String password) {
        this.id = idCounter++;
        this.accountNumber = "ACCT" + id;
        this.holder = holder;
        this.balance = balance;
        this.accountType = accountType;
        this.creationDate = LocalDate.now();
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public AccountHolder getHolder() {
        return holder;
    }

    public void setHolder(AccountHolder holder) {
        this.holder = holder;
    }

    public void setUpdateDate() {
        this.updateDate = LocalDate.now();
    }

    public void setDeletionDate() {
        this.deletionDate = LocalDate.now();
    }

    public String getFormattedDate(LocalDate date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
    }

    @Override
    public void deposit(String accNum, double amount, Map<String, Account> accounts) throws InvalidAccountException {
        if (!accounts.containsKey(accNum))
            throw new InvalidAccountException("Account doesn't exist.");
        accounts.get(accNum).balance += amount;
        accounts.get(accNum).setUpdateDate();
    }

    @Override
    public void transfer(String fromAcc, String toAcc, double amount, Map<String, Account> accounts) throws Exception {
        if (!accounts.containsKey(fromAcc) || !accounts.containsKey(toAcc))
            throw new InvalidAccountException("Invalid Account Number.");
        if (amount <= 0)
            throw new InvalidAccountException("Invalid amount.");
        if (accounts.get(fromAcc).balance < amount)
            throw new InsufficientBalanceException("Insufficient funds.");
        accounts.get(fromAcc).balance -= amount;
        accounts.get(toAcc).balance += amount;
        accounts.get(fromAcc).setUpdateDate();
        accounts.get(toAcc).setUpdateDate();
    }

    @Override
    public void withdraw(String accNum, double amount, Map<String, Account> accounts) throws Exception {
        if (!accounts.containsKey(accNum))
            throw new AccountNotFoundException("Account not found.");
        if (amount <= 0)
            throw new InvalidAccountException("Amount should be positive.");
        Account acc = accounts.get(accNum);
        if (acc.balance < amount)
            throw new InsufficientBalanceException("Insufficient Balance.");
        acc.balance -= amount;
        acc.setUpdateDate();
    }

    public double calculateFDInterest(int years) {
        return balance * (accountType.getInterestRate() / 100) * years;
    }

    @Override
    public double calculateTax() {
        return balance * TAX_RATE;
    }

    @Override
    public int compareTo(Account other) {
        return this.holder.getName().compareTo(other.holder.getName());
    }

    @Override
    public String toString() {
        return "Account{id=" + id +
                ", accNo='" + accountNumber + '\'' +
                ", holder=" + holder +
                ", balance=" + balance +
                ", type=" + accountType +
                ", created=" + getFormattedDate(creationDate) +
                ", updated=" + getFormattedDate(updateDate) +
                ", deleted=" + getFormattedDate(deletionDate) + '}';
    }

}
