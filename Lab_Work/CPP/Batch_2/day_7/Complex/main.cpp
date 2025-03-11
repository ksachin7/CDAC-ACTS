#include <iostream>
#include "Complex.h"

using namespace std;

int main() {
    Complex c1(1.0, 2.0);
    Complex c2(3.0, 4.0);
    Complex c3(5.0, 6.0);

    c1.display();
    c2.display();
    c3.display();

    cout << "Total number of Complex objects created: " << Complex::getObjectCount() << endl;

    return 0;
}
