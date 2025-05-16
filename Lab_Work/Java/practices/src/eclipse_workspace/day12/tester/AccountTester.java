package eclipse_workspace.day12.tester;

import eclipse_workspace.day12.bank.Account;
import java.time.LocalDate;
import java.util.*;

public class AccountTester {

	private static final double MIN_BALANCE = 1000.0;
	private static final List<Account> accList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			printMenu();

			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid number.\n");
				continue;
			}

			switch (choice) {
				case 1:
					validateAndCreateAccount(sc);
					break;
				case 2:
					printAllAccounts();
					break;
				case 3:
					sortByAccNoDesc();
					break;
				case 4:
					sortByAccName();
					break;
				case 5:
					sortByDateOfOpening();
					break;
				case 6:
					sortByBalanceDesc();
					break;
				case 0:
					System.out.println("Exiting...");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice! Try again.\n");
			}
		}
	}

	private static void printMenu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Add Account");
		System.out.println("2. Print all Accounts");
		System.out.println("3. Sort by account no (desc)");
		System.out.println("4. Sort by account name");
		System.out.println("5. Sort by date of opening");
		System.out.println("6. Sort by balance (desc)");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void validateAndCreateAccount(Scanner sc) {
		try {
			System.out.print("Enter Account Number: ");
			int accNo = Integer.parseInt(sc.nextLine());

			if (isDuplicateAccountNo(accNo)) {
				System.out.println("Account number already exists!\n");
				return;
			}

			System.out.print("Enter Account Name: ");
			String accName = sc.nextLine().trim();

			System.out.print("Enter Date of Opening (yyyy-mm-dd): ");
			String dateInput = sc.nextLine().trim();
			LocalDate dateOfOpening = LocalDate.parse(dateInput);
			if (dateOfOpening.isAfter(LocalDate.now())) {
				throw new IllegalArgumentException("Date of opening can't be in the future.");
			}

			System.out.print("Enter Balance: ");
			double balance = Double.parseDouble(sc.nextLine());
			if (balance < MIN_BALANCE) {
				throw new IllegalArgumentException("Balance must be at least " + MIN_BALANCE);
			}

			Account newAcc = new Account(accNo, accName, dateOfOpening, balance);
			accList.add(newAcc);
			System.out.println("✅ Account added successfully.\n");

		} catch (NumberFormatException e) {
			System.out.println("❌ Invalid number entered. Try again.\n");
		} catch (IllegalArgumentException e) {
			System.out.println("❌ " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.out.println("❌ Unexpected error: " + e.getMessage() + "\n");
		}
	}

	private static boolean isDuplicateAccountNo(int accNo) {
		for (Account acc : accList) {
			if (acc.getAccNo() == accNo) {
				return true;
			}
		}
		return false;
	}

	private static void printAllAccounts() {
		if (accList.isEmpty()) {
			System.out.println("No accounts found.\n");
		} else {
			for (Account acc : accList) {
				System.out.println(acc);
			}
			System.out.println();
		}
	}

	private static void sortByAccNoDesc() {
		Collections.sort(accList, new Comparator<Account>() {
			public int compare(Account a1, Account a2) {
				return a2.getAccNo().compareTo(a1.getAccNo());
			}
		});
		System.out.println("Accounts sorted by account number (descending).\n");
	}

	private static void sortByAccName() {
		Collections.sort(accList, new Comparator<Account>() {
			public int compare(Account a1, Account a2) {
				return a1.getAccName().compareToIgnoreCase(a2.getAccName());
			}
		});
		System.out.println("Accounts sorted by name.\n");
	}

	private static void sortByDateOfOpening() {
		Collections.sort(accList, new Comparator<Account>() {
			public int compare(Account a1, Account a2) {
				return a1.getDateOfOpening().compareTo(a2.getDateOfOpening());
			}
		});
		System.out.println("Accounts sorted by date of opening.\n");
	}

	private static void sortByBalanceDesc() {
		Collections.sort(accList, new Comparator<Account>() {
			public int compare(Account a1, Account a2) {
				return a2.getBalance().compareTo(a1.getBalance());
			}
		});
		System.out.println("Accounts sorted by balance (descending).\n");
	}
}
