#include <iostream>
#include "Employee.h"

using namespace std;

int main() {
    Employee e1("John");
    Employee e2("Sara");
    Employee e3("Tom");

    e1.display();
    e2.display();
    e3.display();

    cout << "Total number of employees created: " << Employee::getEmployeeCount() << endl;

    return 0;
}
