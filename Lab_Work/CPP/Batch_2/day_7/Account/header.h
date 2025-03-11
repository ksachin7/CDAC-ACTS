#ifndef __ACCOUNT_H__
#define __ACCOUNT_H__

#include<iostream>
#include<string>
using namespace std;

class Account{
	
	private:
		int accountNo;
		string accountHolderName;
		double balance;
	static int counter;
	
	public:
		Account();
		Account(string accountHolderName, double balance);

		void Accept(string accountHolderName, double balance);

		void Display();

		void addAccount(string accountHolderName, double balance);

		void openAccounts();

		void deposit(double amount);

		void withdraw(double amount);

		bool findAccount(int accountNo);

		int getAccountNumber();

		double getBalance();
};
#endif
