#ifndef COMPLEX_H
#define COMPLEX_H

class Complex {
private:
    static int objectCount;
    double real;
    double imag;

public:
    // Constructors
    Complex();
    Complex(double real, double imag);

    // Methods
    void display() const;

    static int getObjectCount();
};

#endif
