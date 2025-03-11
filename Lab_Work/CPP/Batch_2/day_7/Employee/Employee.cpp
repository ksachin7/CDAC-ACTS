#include "Employee.h"
#include <iostream>
using namespace std;

int Employee::employeeCount = 0;

Employee::Employee() {
    employeeId = ++employeeCount;
    name = "Unknown";
}

Employee::Employee(string name) {
    employeeId = ++employeeCount;
    this->name = name;
}

void Employee::display() const {
    cout << "Employee ID: " << employeeId << ", Name: " << name << endl;
}

int Employee::getEmployeeCount() {
    return employeeCount;
}
