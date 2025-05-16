package com.cdac.acts.Tester;

import com.cdac.acts.bank.*;
import com.cdac.acts.bank.exception.MinBalException;

import java.util.Arrays;
import java.util.Scanner;

public class BankMain {

    public static void displayAccounts(Account []accounts){
        System.out.println("\n--- Account Details ---");
        for (Account acc: accounts){
            if(acc != null)
                System.out.println(acc);
        }
        System.out.println("-----------------------");
    }

//    private static Account findAccount(String accountNumber, Account [] accounts) {
//        for (Account account : accounts) {
//            if (account.getAccountNumber().equals(accountNumber)) {
//                return account;
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        
        int index=0;
        Account []accounts= new Account[100];   // took a default size=100

        int choice;
        do{
            System.out.println("\n======= MENU =======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Calculate Maturity Amount");
            System.out.println("5. Display Accounts");

            choice= scanner.nextInt();

            switch(choice) {

                case 0:
                    System.out.println("Exiting.. Goodbye!");
                    break;
                case 1:
                    System.out.println("Please enter your choice: ");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.println("3. Fixed Deposit Account");

                    System.out.print("Enter account type: ");
                    int ch = scanner.nextInt();
//                    scanner.nextLine();

                    Account newAccount = null;
                    switch(ch){
                        case 1:
                            newAccount = new SavingsAccount("Savings");
                            break;
                        case 2:
                            newAccount = new CurrentAccount("Current");
                            break;
                        case 3:
                            newAccount = new FixedDepositAccount("FD");
                            // ask for tenure here
                            break;
                        default:
                            System.out.println("Invalid account type choice.");
                            break;
                    }

                    if (newAccount != null) {
                        accounts[index++] = newAccount;
                        System.out.println(newAccount.getAccountName() + " Account created!\nYour account number is: " + newAccount.getAccountNumber());
                        System.out.println(Arrays.toString(Arrays.copyOf(accounts, index))); // Print created accounts
                    }
                    break;

                case 2: {
                    System.out.println("Please enter account no: ");
                    boolean invalidAccount = false, invalidAccType = false;
                    String accNo = scanner.next();
                    for (int i = 0; i < accounts.length && accounts[i]!= null; i++) {
                        System.out.println(accounts[i]);
                        if (accounts[i].getAccountNumber().equals(accNo)) {
                            System.out.println("Please enter account name/type(Current, Savings, FD): ");
                            String accType = scanner.next();
                            if (accounts[i].getAccountName().equalsIgnoreCase(accType)) {
                                System.out.println("Please enter amount to deposit: ");
                                double amt = scanner.nextDouble();
                                accounts[i].deposit(amt);
                                invalidAccType=false;
                                invalidAccount=false;
                                break;
                            } else {
                                invalidAccType = true;
                            }
                        } else {
                            invalidAccount = true;
                        }
                    }
                    if (invalidAccount) System.out.println("Invalid account number!");
                    if (invalidAccType) System.out.println("Invalid account type!");
                }
                    break;
                case 3: {
                    System.out.println("Please enter account no: ");
                    boolean invalidAccount = false, invalidAccType = false;
                    String accNo = scanner.next();
                    try {
                    	for (int i = 0; i < accounts.length && accounts[i]!= null; i++) {
//                            System.out.println(accounts[i]);
                            if (accounts[i].getAccountNumber().equals(accNo)) {
                                System.out.println("Please enter account name/type(Current, Savings, FD): ");
                                String accType = scanner.next();
                                if (accounts[i].getAccountName().equalsIgnoreCase(accType)) {
                                    System.out.println("Please enter amount to deposit: ");
                                    double amt = scanner.nextDouble();
                                    accounts[i].withdraw(amt);
                                    invalidAccType=false;
                                    invalidAccount=false;
                                    break;
                                } else {
                                    invalidAccType = true;
                                }
                            } else {
                                invalidAccount = true;
                            }
                        }
                        if (invalidAccount) System.out.println("Invalid account number!");
                        if (invalidAccType) System.out.println("Invalid account type!");
                    }
                    catch(MinBalException e) {
                    	e.printStackTrace();
                    }
                }
                break;

                case 4:
                    System.out.print("Enter account number of Deposit Account: ");
                    String accountNumber = scanner.next();

                    for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
                        if(accounts[i].getAccountNumber().equals(accountNumber)){
                            if (accounts[i] instanceof Maturable) {
                                Maturable matureAccount = (Maturable) accounts[i];
                                System.out.println("Maturity Amount for Account " + accountNumber + ": "
                                        + String.format("%.2f", matureAccount.calculateMaturityAmount()));
                            } else if (accounts[i] != null) {
                                System.out.println("Maturity calculation is only applicable for Deposit Accounts.");
                            } else {
                                System.out.println("Account not found with account number: " + accountNumber);
                            }
                        }
                    }
                    break;

                case 5:
                    displayAccounts(accounts);
                    break;

                default: System.out.println("Invalid choice. Try again!");
            }

        }while(choice != 0);
    	
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
