package com.cdac.acts.bank;

import com.cdac.acts.bank.exception.AccountNotFoundException;
import com.cdac.acts.bank.utils.BankUtils;
import com.cdac.acts.bank.utils.ValidationUtils;

import java.util.*;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        // test data
        accounts= BankUtils.populateSampleAccounts();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Add Account");
            System.out.println("2. Display Account by Number");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Remove Account");
            System.out.println("5. Withdraw");
            System.out.println("6. Deposit");
            System.out.println("7. Transfer");
            System.out.println("8. Sort by Name (A-Z)");
            System.out.println("9. Sort by Balance (High to Low)");
            System.out.println("10. Calculate FD Interest & Tax");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter: Name, Email, Phone, Balance, AccountType, Password");
                        String name = sc.next();
                        String email = sc.next();
                        String phone = sc.next();
                        double balance = sc.nextDouble();
                        String type = sc.next();
                        String password = sc.next();

                        ValidationUtils.validate(email, phone, balance, password);

                        AccountHolder holder = new AccountHolder(name, email, phone);
                        Account acc = new Account(holder, balance, AccountType.valueOf(type.toUpperCase()), password);
                        accounts.put(acc.getAccountNumber(), acc);
                        System.out.println("Account Created: " + acc.getAccountNumber());
                    }
                    case 2 -> {
                        System.out.print("Enter Account Number: ");
                        String accNum = sc.next();
                        Account acc = accounts.get(accNum);
                        if (acc == null) throw new AccountNotFoundException("No such account");
                        System.out.println(acc);
                    }
                    case 3 -> accounts.values().forEach(System.out::println);
                    case 4 -> {
                        System.out.print("Enter Account Number to Remove: ");
                        String remAcc = sc.next();
                        Account acc = accounts.remove(remAcc);
                        if (acc == null) throw new AccountNotFoundException("Account not found.");
                        acc.setDeletionDate();
                        System.out.println("Account removed successfully.");
                    }
                    case 5 -> {
                        System.out.print("Account Number & Amount: ");
                        String accNum = sc.next();
                        double amt = sc.nextDouble();
                        accounts.get(accNum).withdraw(accNum, amt, accounts);
                        System.out.println("Withdrawal Successful.");
                    }
                    case 6 -> {
                        System.out.print("Account Number & Amount: ");
                        String accNum = sc.next();
                        double amt = sc.nextDouble();
                        accounts.get(accNum).deposit(accNum, amt, accounts);
                        System.out.println("Deposit Successful.");
                    }
                    case 7 -> {
                        System.out.print("From Account, To Account, Amount: ");
                        String from = sc.next();
                        String to = sc.next();
                        double amt = sc.nextDouble();
                        accounts.get(from).transfer(from, to, amt, accounts);
                        System.out.println("Transfer Complete.");
                    }
                    case 8 -> {
                        System.out.println("Sorted by Name (Natural Order):");
                        accounts.values().stream()
                                .sorted()
                                .forEach(System.out::println);
                    }
                    case 9 -> {
                        System.out.println("Sorted by Balance (High to Low):");
                        accounts.values().stream()
                                .sorted(Comparator.comparing(Account::getBalance).reversed()
                                            .thenComparing(acc -> acc.getHolder().getName()))
                                .forEach(System.out::println);
                    }
                    case 10 -> {
                        System.out.print("Enter Account Number & FD Years: ");
                        String accNum = sc.next();
                        int years = sc.nextInt();
                        Account acc = accounts.get(accNum);
                        if (acc == null) throw new AccountNotFoundException("Account not found");
                        double interest = acc.calculateFDInterest(years);
                        double tax = acc.calculateTax();
                        System.out.println("Interest earned: ₹" + interest);
                        System.out.println("Tax payable: ₹" + tax);
                    }
                    case 11 -> {
                        System.out.println("Exiting. Bye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                // Centralized error message
                System.out.println("[Error] " + e.getMessage());
                sc.nextLine(); // clean buffer
            }
        }
        sc.close();
    }
}
