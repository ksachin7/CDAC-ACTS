package com.cdac.acts;

class BankAccount {
    // Static variable to keep track of the total number of accounts
    static int totalAccounts = 0;
    
    // Instance variables
    String accountHolderName;
    double balance;
    
    // Static block to initialize settings or configurations
    static {
        System.out.println("Static Block: Initializing Bank Account system...");
    }

    // Static method to display the total number of accounts
    public static void displayTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }

    // Constructor that creates a bank account and updates the total number of accounts
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        
        totalAccounts++; // Increment totalAccounts each time a new account is created
        System.out.println("New account created for " + accountHolderName);
    }

    // Static method to simulate deposit to a new bank account
    public static void depositToAccount(BankAccount account, double amount) {
        account.balance += amount;
        System.out.println(amount + " deposited to account of " + account.accountHolderName);
    }

    // Static method to simulate withdrawal from a bank account
    public static void withdrawFromAccount(BankAccount account, double amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println(amount + " withdrawn from account of " + account.accountHolderName);
        } else {
            System.out.println("Insufficient balance for " + account.accountHolderName);
        }
    }

    // Static method to display account balance
    public static void displayBalance(BankAccount account) {
        System.out.println(account.accountHolderName + "'s current balance: " + account.balance);
    }

    public static void main(String[] args) {
        // Static method call to display total accounts before creating any instances
        displayTotalAccounts();  // Output: Total Accounts Created: 0

        // Creating new accounts (this increments the static totalAccounts variable)
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);
        BankAccount account3 = new BankAccount("Charlie", 2000.0);

        // Static method call to display total accounts after creating instances
        displayTotalAccounts();  // Output: Total Accounts Created: 3

        // Perform some operations on accounts (using static methods)
        account1.depositToAccount(account1, 500.0);  // Alice's account gets a deposit of 500
        withdrawFromAccount(account2, 100.0);  // Bob withdraws 100
        displayBalance(account1);  // Show Alice's balance
        displayBalance(account2);  // Show Bob's balance
        displayBalance(account3);  // Show Charlie's balance

        // Attempting a withdrawal with insufficient funds
        withdrawFromAccount(account2, 1000.0);  // Bob has insufficient funds
    }
}
