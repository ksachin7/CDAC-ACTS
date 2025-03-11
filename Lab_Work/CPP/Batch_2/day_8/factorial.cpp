#include <iostream>
using namespace std;

int factorial(const int &n) {
    // n = 5; // This line would cause an error because n is a const reference
    int fact = 1;
    for (int i = 1; i <= n; ++i) {
        fact *= i;
    }
    return fact;
}

int main() {
    int num = 5;
    cout << "Factorial of " << num << " is " << factorial(num) << endl;
    return 0;
}
