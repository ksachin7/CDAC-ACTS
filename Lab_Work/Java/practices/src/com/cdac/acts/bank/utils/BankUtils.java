package com.cdac.acts.bank.utils;
import com.cdac.acts.bank.Account;
import com.cdac.acts.bank.AccountHolder;
import com.cdac.acts.bank.AccountType;

import java.util.HashMap;
import java.util.Map;

import static com.cdac.acts.bank.AccountType.SAVINGS;

public class BankUtils {
    public static Map<String, Account> initializeAccounts() {
        return new HashMap<>();
    }

    // test data
    public static Map<String, Account> populateSampleAccounts() {
        Map<String, Account> accounts = new HashMap<>();

        // Sample account holders
        AccountHolder ah1 = new AccountHolder("Alice", "alice@mail.com", "9999911111");
        AccountHolder ah2 = new AccountHolder("Bob", "bob@mail.com", "9999922222");
        AccountHolder ah3 = new AccountHolder("Charlie", "charlie@mail.com", "9999933333");
        AccountHolder ah4 = new AccountHolder("David", "david@mail.com", "9999944444");
        AccountHolder ah5 = new AccountHolder("Eva", "eva@mail.com", "9999955555");

        // Sample accounts (name, balance, type, password)
        Account acc1 = new Account(ah1, 25000, AccountType.valueOf("SAVINGS"), "pass1");
        Account acc2 = new Account(ah2, 45000, AccountType.CURRENT, "pass2");
        Account acc3 = new Account(ah3, 150000, AccountType.FIXED_DEPOSIT, "pass3");
        Account acc4 = new Account(ah4, 25000, SAVINGS, "pass4"); // same balance as acc1
        Account acc5 = new Account(ah5, 5000, SAVINGS, "pass5");

        // Add to map
        accounts.put(acc1.getAccountNumber(), acc1);
        accounts.put(acc2.getAccountNumber(), acc2);
        accounts.put(acc3.getAccountNumber(), acc3);
        accounts.put(acc4.getAccountNumber(), acc4);
        accounts.put(acc5.getAccountNumber(), acc5);

        return accounts;
    }

}
