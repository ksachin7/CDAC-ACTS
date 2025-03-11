
#include<iostream>
#include "header.h"

using namespace std;

// Initialize the static counter
int Account::counter = 0;

const int MAX_ACCOUNTS = 100;  // Maximum number of accounts that can be created

int main() {
    Account* accounts[MAX_ACCOUNTS];  // Array to store account pointers
    int accountCount = 0;  // Keep track of how many accounts have been created
    int choice;
    bool running = true;

    while (running) {
        cout << "\n----------- Menu ------------\n";
        cout << "1. Open Account\n";
        cout << "2. Display Account Details\n";
        cout << "3. Deposit Money\n";
        cout << "4. Withdraw Money\n";
        cout << "5. Find account by account no.\n";
        cout << "6. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                string name;
                double balance;
                cout << "Enter account holder's name: ";
                cin >> name;
                cout << "Enter initial deposit: ";
                cin >> balance;

                if (accountCount < MAX_ACCOUNTS) {
                    accounts[accountCount] = new Account(name, balance);
                    cout << "Account created successfully!" << endl;
                    accountCount++;
                } else {
                    cout << "Account limit reached!" << endl;
                }
                break;
            }
            case 2: {
                if (accountCount > 0) {
                    for (int i = 0; i < accountCount; i++) {
                        accounts[i]->Display();
                    }
                } else {
                    cout << "No accounts available!" << endl;
                }
                break;
            }
            case 3: {
                if (accountCount > 0) {
                    int accountNoToFind;
                    cout << "Enter account number to deposit money: ";
                    cin >> accountNoToFind;

                    bool found = false;
                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i]->getAccountNumber() == accountNoToFind) {
                            double depositAmount;
                            cout << "Enter amount to deposit: ";
                            cin >> depositAmount;
                            accounts[i]->deposit(depositAmount);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                } else {
                    cout << "No accounts available!" << endl;
                }
                break;
            }
            case 4: {
                if (accountCount > 0) {
                    int accountNoToFind;
                    cout << "Enter account number to withdraw money: ";
                    cin >> accountNoToFind;

                    bool found = false;
                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i]->getAccountNumber() == accountNoToFind) {
                            double withdrawAmount;
                            cout << "Enter amount to withdraw: ";
                            cin >> withdrawAmount;
                            accounts[i]->withdraw(withdrawAmount);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                } else {
                    cout << "No accounts available!" << endl;
                }
                break;
            }
            case 5: {
                if (accountCount > 0) {
                    int accountNoToFind;
                    cout << "Enter account number to search: ";
                    cin >> accountNoToFind;

                    bool found = false;
                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i]->getAccountNumber() == accountNoToFind) {
                            accounts[i]->Display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        cout << "Account not found!" << endl;
                    }
                } else {
                    cout << "No accounts available!" << endl;
                }
                break;
            }
            case 6:
                running = false;
                cout << "Exiting program." << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    }

    // Clean up all the dynamically allocated accounts
    for (int i = 0; i < accountCount; i++) {
        delete accounts[i];
    }

    return 0;
}