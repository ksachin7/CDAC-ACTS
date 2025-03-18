#include <iostream>
#include <stdexcept>
#include <string>

class Account {
private:
    std::string accountHolderName;
    std::string accountNumber;
    double balance;

public:
    // Constructor to initialize account
    Account(std::string name, std::string accNo, double initialBalance)
        : accountHolderName(name), accountNumber(accNo), balance(initialBalance) {}

    // Function to display account details
    void displayAccountDetails() {
        std::cout << "Account Holder: " << accountHolderName << std::endl;
        std::cout << "Account Number: " << accountNumber << std::endl;
        std::cout << "Balance: " << balance << std::endl;
    }

    // Function to withdraw money
    void withdraw(double amount) {
        if (balance - amount < 1000) {  // Low balance check
            throw std::runtime_error("Low balance. Your balance cannot go below 1000.");
        }
        if (amount > balance) {
            throw std::runtime_error("Insufficient funds.");
        }
        balance -= amount;
        std::cout << "Withdrawal successful! Amount withdrawn: " << amount << std::endl;
    }

    // Function to deposit money
    void deposit(double amount, std::string panCard = "") {
        if (amount > 50000 && panCard.empty()) {  // PAN Card required for deposits > 50000
            throw std::runtime_error("PAN card is required for deposits greater than 50,000.");
        }
        balance += amount;
        std::cout << "Deposit successful! Amount deposited: " << amount << std::endl;
    }

    // Getter for balance
    double getBalance() const {
        return balance;
    }
};

int main() {
    try {
        Account acc("John Doe", "1234567890", 5000);

        // Display account details
        acc.displayAccountDetails();

        // Deposit amount (with PAN card if over 50000)
        acc.deposit(60000, "ABCDE1234F"); // Add PAN card details for large deposit

        // Display account details after deposit
        acc.displayAccountDetails();

        // Withdraw amount
        acc.withdraw(4500);  // Should succeed

        // Display account details after withdrawal
        acc.displayAccountDetails();

        // Attempting to withdraw more than available (should throw an error)
        acc.withdraw(5000);

    } catch (const std::exception &e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    return 0;
}
