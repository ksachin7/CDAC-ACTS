package com.cdac.acts.bank.service;

import com.cdac.acts.bank.Account;

import java.util.Map;

public abstract class BankService {
    public abstract void deposit(String accNum, double amount, Map<String, Account> accounts) throws Exception;
    public abstract void transfer(String fromAcc, String toAcc, double amount, Map<String, Account> accounts) throws Exception;
    public abstract void withdraw(String accNum, double amount, Map<String, Account> accounts) throws Exception;
}
