package com.cdac.acts.tester;

import com.cdac.acts.bank.*;
import com.cdac.acts.bank.exception.AccountNotFoundException;
import com.cdac.acts.bank.exception.MinBalException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class BankMain {
	private static String accNo;
	private static Double MIN_BAL_REQUIRED= 1000.0;
	
	private static List<Account> accList = new CopyOnWriteArrayList<>();

	public static void displayAccounts(List<Account> accounts) {
		System.out.println("\n\t\t\t------------------ Account Details ------------------");

		for (Account acc : accounts) {
			System.out.println(acc);
		}
//		System.out.println("\t\t\t------------------------------------------------------");
	}

	private static Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account account : accList) {
//			System.out.println(account.getAccountNumber());
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountNotFoundException("The account no: "+accountNumber+ " doesn't exist!");
	}

	private static void fundTransfer(Scanner scanner) throws MinBalException, AccountNotFoundException {
		System.out.println("Enter Account no to withdraw");
		String wacc = scanner.next();
		System.out.println("Enter Account no to deposit");
		String dacc = scanner.next();
		
		System.out.println("Enter Amount to transfer");
		Double amt = scanner.nextDouble();
		
		if(wacc.equalsIgnoreCase(dacc)) 
			throw new IllegalArgumentException("Witdarwal and Deposit Account can't be same!");
			
		findAccount(wacc).withdraw(amt);
		findAccount(dacc).deposit(amt);
	}
	
	private static void removeAccount(String accountNumber) {
		try {
			accList.remove(findAccount(accountNumber));
		}catch(AccountNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			int choice;
			do {
				System.out.println("\n=================== MENU ===================");
				System.out.println("0. Exit\n"
						+ "1. Create Account\n"
						+ "2. Display all Accounts\n"
						+ "3. Search Account\n"
						+ "4. Fund transfer.\n"
						+ "5. Remove A/C from List\n"
						+ "6. Apply interest on all saving A/C\n"
						+ "7. Sort accounts as per ascending A/C No.\n"
						+ "8. Sort by Account Opening Date");

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
					
					Account newAccount = null;
					
					System.out.println("Please enter initial balance");
					double bal= scanner.nextDouble();
					if(bal<= MIN_BAL_REQUIRED) throw new MinBalException("Balance should be more than 1000!");
					
					switch (ch) {
					case 1:
						newAccount = new SavingsAccount("Savings", bal);
						break;
					case 2:
						newAccount = new CurrentAccount("Current", bal);
						break;
					case 3:
						newAccount = new FixedDepositAccount("FD", bal);
						break;
					default:
						System.out.println("Invalid account type choice.");
						break;
					}

					if (newAccount != null) {
						accList.add(newAccount);
						System.out.println(newAccount.getAccountName() + " Account created!\nYour account number is: "
								+ newAccount.getAccountNumber());
					}
					break;

				case 2:
					displayAccounts(accList);
					break;

				case 3:
					System.out.println("\nPlease enter account no to find");
					accNo= scanner.next();
					System.out.println(findAccount(accNo));
					break;

				case 4:
					fundTransfer(scanner);					
					break;

				case 5:
					System.out.println("Please enter account no to remove");
					accNo= scanner.next();
					removeAccount(accNo);
					break;
					
				case 6:
					for(Account acc: accList) {
					 if(acc.getAccountName().equalsIgnoreCase("savings")){
						 acc.applyInterest();
					 }
					}
				break;
				
				case 7:
					Comparator<Account> accNoComparator= new Comparator<Account>() {

						@Override
						public int compare(Account o1, Account o2) {
							return o1.getAccountNumber().compareTo(o2.getAccountNumber());
						}
						
					};
					Collections.sort(accList, accNoComparator);
				break;
				
				case 8:
					Comparator<Account> accDoOComparator= new Comparator<Account>() {

						@Override
						public int compare(Account o1, Account o2) {
							return o1.getDateOfOpening().compareTo(o2.getDateOfOpening());
						}
						
					};
					Collections.sort(accList, accDoOComparator);
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
