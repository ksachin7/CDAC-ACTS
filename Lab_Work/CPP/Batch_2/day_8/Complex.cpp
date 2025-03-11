#include <iostream>
using namespace std;

class Complex {
private:
    float real;
    float imag;

public:
    Complex(float r = 0, float i = 0) : real(r), imag(i) {}

    // Overload + operator
    Complex operator+(const Complex &other) {
        return Complex(real + other.real, imag + other.imag);
    }

    // Overload - operator
    Complex operator-(const Complex &other) {
        return Complex(real - other.real, imag - other.imag);
    }

    // Overload * operator
    Complex operator*(const Complex &other) {
        return Complex(real * other.real - imag * other.imag, real * other.imag + imag * other.real);
    }

    void display() {
        cout << real << " + " << imag << "i" << endl;
    }
};

int main() {
    Complex c1(3, 4), c2(1, 2), result;

    cout << "Complex number 1: ";
    c1.display();
    cout << "Complex number 2: ";
    c2.display();

    result = c1 + c2;
    cout << "Addition: ";
    result.display();

    result = c1 - c2;
    cout << "Subtraction: ";
    result.display();

    result = c1 * c2;
    cout << "Multiplication: ";
    result.display();

    return 0;
}
