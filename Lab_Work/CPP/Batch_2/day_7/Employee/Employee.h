#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>
using namespace std;

class Employee {
private:
    static int employeeCount;
    int employeeId;
    string name;

public:
    Employee();
    Employee(string name);

    // Methods
    void display() const;

    static int getEmployeeCount();
};

#endif
