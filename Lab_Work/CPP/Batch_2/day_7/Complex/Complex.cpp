#include "Complex.h"
#include <iostream>
using namespace std;

int Complex::objectCount = 0;

Complex::Complex() {
    real = 0.0;
    imag = 0.0;
    ++objectCount;
}

Complex::Complex(double real, double imag) {
    this->real = real;
    this->imag = imag;
    ++objectCount;
}

void Complex::display() const {
    cout << "Complex Number: " << real << " + " << imag << "i" << endl;
}

int Complex::getObjectCount() {
    return objectCount;
}
