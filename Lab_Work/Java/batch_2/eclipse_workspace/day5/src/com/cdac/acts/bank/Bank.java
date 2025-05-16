package com.cdac.acts.bank;
import java.util.Scanner;

public class Bank {
	int acc_no;
	String cust_name;
	double balance;
	static int base_acc_no= 1100101164;

	public Bank() {}
	
	public Bank(String cust_name, double balance) {
		acc_no= base_acc_no++;
		this.cust_name=cust_name;
		this.balance= balance;
		System.out.println(acc_no);
	}
	
	void transferBalance(Bank []accounts,double amt, int Withdraw_acc_no, int Deposite_acc_no,int index) {
		
		for(int i=0; i<index; i++) {
//			System.out.println(accounts[i].acc_no +" "+ Withdraw_acc_no);
			if(accounts[i].acc_no == Withdraw_acc_no) {
				accounts[i].balance -= amt;
			}
			else if(accounts[i].acc_no == Deposite_acc_no) {
				accounts[i].balance += amt;
			}
			else System.out.println("Something went wrong!");
		}
		
	}
	
	void deposit(double amt) {
		if(amt < 0) {
			System.out.println("Can't deposit! Amount can't be negative.");
			return;
		}
		balance+= amt;
	}
	
	void withdraw(int account_no, double amt, Bank []accounts) {
		if(balance < amt && amt <0) {
			System.out.println("Please enter a valid amount!");
			return;
		}
		for(int i=0; i<accounts.length; i++) {
			if(accounts[i].acc_no == account_no){
				accounts[i].balance-=amt;
				System.out.println("Amount "+amt + " has been withdrawn!\n Current Balance: "+ accounts[i].balance);
				break;
			}
		}
	}
	
	public double displayBalance(int account_no, Bank []accounts) {
		for(int i=0; i<accounts.length; i++) {
			if(accounts[i].acc_no == account_no)
				return accounts[i].balance;
			else
				System.out.println("Invalid Account!");
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank= new Bank();
		
		int size=10;
		int index=0;
		Bank []accounts= new Bank[size];
		
		while(true) {
			System.out.println();
			System.out.println("Please enter your choice:\n"
					+ "1. Add account\r\n"
					+ "2. Display balance of particular\r\n"
					+ "3. Withdraw\r\n"
					+ "4. Transfer\r\n"
					+ "5. Exit"
					);
				int choice= sc.nextInt();
				
				if(choice == 1) {
					System.out.println("Please enter your name: ");
					String name= sc.next();
					System.out.println("Please enter initial balance: ");
					double bal= sc.nextDouble();
					accounts[index++]= new Bank(name, bal);
				}
				else if(choice == 2) {
					System.out.println("Please enter your account no: ");
					int account_no=sc.nextInt();
					double bal= bank.displayBalance(account_no, accounts);
					System.out.println("Balance: " + bal);
				}
				else if(choice == 3) {
					System.out.println("Please enter your account no: ");
					int account_no=sc.nextInt();
					System.out.println("Please enter amount to withdraw: ");
					double amt= sc.nextDouble();
					bank.withdraw(account_no, amt, accounts);
				}
				else if(choice == 4) {
					System.out.println("Please enter your account no from you want to transfer: ");
					int W_acc_no=sc.nextInt();
					System.out.println("Please enter your account no in which want to transfer: ");
					int D_acc_no=sc.nextInt();
					System.out.println("Please enter amount to transfer: ");
					double amt= sc.nextDouble();
					bank.transferBalance(accounts, amt, W_acc_no, D_acc_no,index);
					System.out.println(amt+ " has been transfered from Account: "+W_acc_no+ " to Account: "+D_acc_no);
				}
				else {
					return;
				}
		}
	}

}
