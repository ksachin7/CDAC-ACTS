package eclipse_workspace.day10.Tester;

import eclipse_workspace.day10.bank.*;
import eclipse_workspace.day10.bank.exception.MinBalException;

import java.time.LocalDate;
import java.util.*;

public class BankMain {
    private static boolean dummyAdded = false;

    public static void displayAccounts(List<Account> accounts) {
        System.out.println("\n--- Account Details ---");
        for (Account acc : accounts) {
            if (acc != null)
                System.out.println(acc);
        }
        System.out.println("-----------------------");
    }

    private static Account findAccount(String accNo, List<Account> accounts) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    private static boolean isDuplicateAccNumber(String accNo, List<Account> accounts) {
        return findAccount(accNo, accounts) != null;
    }

    private static void handleTransaction(Scanner scanner, List<Account> accounts, boolean isDeposit) throws MinBalException {
        System.out.print("Enter account number: ");
        String accNo = scanner.next();
        Account account = findAccount(accNo, accounts);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter account type (Current, Savings, FD): ");
        String accType = scanner.next();
        if (!account.getAccountName().equalsIgnoreCase(accType)) {
            System.out.println("Incorrect account type!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        if (isDeposit) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        }
    }

    private static void sortAccountsMenu(List<Account> accounts, Scanner scanner) {
        System.out.println("\n--- Sort Options ---");
        System.out.println("1. Sort by Account Number (Ascending)");
        System.out.println("2. Sort by Account Number (Descending)");
        System.out.println("3. Sort by Account Type");
        System.out.println("4. Sort by Balance (Descending)");
        System.out.print("Enter your choice: ");

        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                accounts.sort(Comparator.comparing(Account::getAccountNumber));
                System.out.println("Sorted by Account Number (Ascending).");
                break;

            case 2:
                accounts.sort((a, b) -> b.getAccountNumber().compareTo(a.getAccountNumber()));
                System.out.println("Sorted by Account Number (Descending).");
                break;

            case 3:
                accounts.sort(Comparator.comparing(Account::getAccountName));
                System.out.println("Sorted by Account Type.");
                break;

            case 4:
                accounts.sort((a, b) -> Double.compare(b.getBalance(), a.getBalance()));
                System.out.println("Sorted by Balance (Descending).");
                break;

            default:
                System.out.println("Invalid sort option!");
        }
    }

    // Upper bound: reading from a list (T or a subclass)
    public static void printAccountNames(List<? extends Account> list) {
        for (Account acc : list) {
            System.out.println(acc.getAccountName());
        }
    }

    // Lower bound: writing to a list (T or a subclass)
    public static void addDummyAccount(List<? super Account> list) {
        if (!dummyAdded) {
            list.add(new SavingsAccount("Default"));
            //		list.add(new SavingsAccount(999, "Dummy", LocalDate.now(), 2000));	// If SavingsAccount is a subclass of Account
            dummyAdded = true;
            System.out.println("Dummy account added.");
        } else {
            System.out.println("Dummy account already added. Skipping.");
        }

//		Account acc= list.get(1); 	// CE
        Object obj= list.get(0);
        System.out.println(obj);
    }

    // Return unmodifiable list
    public static List<Account> getUnmodifiableAccountList(List<Account> accounts) {
        return Collections.unmodifiableList(accounts);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            List<Account> accounts = new LinkedList<>();
            int choice = -1;

            do {
                System.out.println("\n======= MENU =======");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Calculate Maturity Amount");
                System.out.println("5. Display Accounts");
                System.out.println("6. Sort Accounts");
                System.out.println("7. Test Bounds and Unmodifiable List");
                System.out.println("0. Exit");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                choice = scanner.nextInt();

                switch (choice) {
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
                        scanner.nextLine(); // consume newline

                        Account newAccount = null;
                        switch (ch) {
                            case 1:
                                newAccount = new SavingsAccount("Savings");
                                break;
                            case 2:
                                newAccount = new CurrentAccount("Current");
                                break;
                            case 3:
                                newAccount = new FixedDepositAccount("FD");
                                break;
                            default:
                                System.out.println("Invalid account type choice.");
                                break;
                        }

                        if (newAccount != null) {
                            if (isDuplicateAccNumber(newAccount.getAccountNumber(), accounts)) {
                                System.out.println("An account with this number already exists.");
                            } else {
                                accounts.add(newAccount);
                                System.out.println(newAccount.getAccountName() + " Account created!");
                                System.out.println("Your account number is: " + newAccount.getAccountNumber());
                            }
                        }
                        break;

                    case 2:
                        handleTransaction(scanner, accounts, true);
                        break;

                    case 3:
                        try {
                            handleTransaction(scanner, accounts, false);
                        } catch (Exception e) {
                            System.out.println("Error during withdrawal: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter account number of Deposit Account: ");
                        String accountNumber = scanner.next();
                        Account acc = findAccount(accountNumber, accounts);

                        if (acc == null) {
                            System.out.println("Account not found.");
                        } else if (acc instanceof Maturable) {
                            double amount = ((Maturable) acc).calculateMaturityAmount();
                            System.out.printf("Maturity Amount for Account %s: %.2f\n", accountNumber, amount);
                        } else {
                            System.out.println("Maturity calculation is only applicable for Deposit Accounts.");
                        }
                        break;

                    case 5:
                        displayAccounts(accounts);
                        break;

                    case 6:
                        sortAccountsMenu(accounts, scanner);
                        break;

                    case 7:
                        addDummyAccount(accounts);
                        printAccountNames(accounts);

                        List<Account> readonlyList = getUnmodifiableAccountList(accounts);
                        System.out.println("Unmodifiable list created. Trying to modify will cause exception.");

                        // Uncomment to test: This will throw UnsupportedOperationException
                        // readonlyList.add(new Account(200, "Hacker", LocalDate.now(), 1000));
                        break;


                    default:
                        System.out.println("Invalid choice. Try again!");
                }

            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
