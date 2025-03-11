#include<iostream>
#include<string>
#include"header.h"

using namespace std;

Account::Account(){
	accountNo= ++counter;
	accountHolderName="";
	balance=0.0;
}

Account::Account(string accountHolderName, double balance){
	accountNo =  ++counter;
	this->accountHolderName = accountHolderName;
	this->balance = balance;
}

void Account::deposit(double amount){
	if(amount > 0){
		balance += amount;
		cout<< "\nDeposited amount: "<< amount <<endl;
	}
	else{
		cout<<"Invalid amount! Please enter a valid amount."<<endl;
	}
}

void Account::withdraw(double amount){
	if(amount > 0 && balance >= amount){	
		balance -= amount;
		cout<<"\nAmount withdrown: "<<amount<<endl;
	}
	else
        cout << "Can't withdraw! Insufficient balance or invalid amount." << endl;    
}


// Method to check if the account exists by account number
// bool Account::findAccount(int accountNo) {
//     return this->accountNo == accountNo;
// }


void Account::Accept( string accountHolderName, double balance){
	// this->accountNo= accountNo+counter;
	this->accountHolderName= accountHolderName;
	this->balance= balance;
}

int Account::getAccountNumber(){
	return accountNo;
}

double Account::getBalance(){
	return balance;
}


void Account::Display(){
	cout<<"\n--------- "<<this->accountHolderName<<"'s Account ---------"<<endl;
	cout<<"Account No: "<<this->accountNo<< "\nAccountHolderName: "<<this->accountHolderName<<"\nbalance: "<<this->balance<<" "<<endl;
	cout<<"---------------------------------"<<endl;
}
