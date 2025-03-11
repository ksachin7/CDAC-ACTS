#include <iostream>
using namespace std;

class Account {
public:
    string name;
    double balance;

    Account(string acc_name, double acc_balance) {
        name = acc_name;
        balance = acc_balance;
    }

    void display() {
        cout << "Account Name: " << name << ", Balance: " << balance << endl;
    }
};

int main() {
    Account *accounts[3];  // Array of pointers to Account objects
    accounts[0] = new Account("John", 1000.50);
    accounts[1] = new Account("Alice", 2000.75);
    accounts[2] = new Account("Bob", 1500.30);

    for (int i = 0; i < 3; ++i) {
        accounts[i]->display();
    }

    for (int i = 0; i < 3; ++i) {
        delete accounts[i];
    }

    return 0;
}
