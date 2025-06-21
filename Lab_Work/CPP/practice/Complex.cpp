#include <iostream>
using namespace std;

class Complex {
private:
    double real;
    double imag;

public:
    // Constructor
    Complex(double r = 0, double i = 0) : real(r), imag(i) {}

    // Overload the '+' operator
    Complex operator+(const Complex& other) {
        return Complex(real + other.real, imag + other.imag);
    }

    // Display function
    void display() const {
        cout << real << " + " << imag << "i" << endl;
    }
};

int main() {
    Complex c1(3.5, 2.0);
    Complex c2(1.5, 4.5);

    Complex sum = c1 + c2;  // uses overloaded +

    cout << "c1: ";
    c1.display();

    cout << "c2: ";
    c2.display();
    
    cout << "Sum: ";
    sum.display();

    return 0;
}
