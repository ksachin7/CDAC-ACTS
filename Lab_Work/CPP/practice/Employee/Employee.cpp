#include <iostream>
#include <string>
#include"Employee.h"

using namespace std;

    // Employee(){}
    Employee::Employee(const string &companyName, const string &employeeName, double salary, int noOfLeave):
    companyName(companyName), employeeName(employeeName), salary(salary), noOfLeave(noOfLeave){}

    // void Employee::displaySalary()
    // {
    //     cout << "Company name: " << companyName << endl;
    //     // getline(cin, companyName);

    //     cout << "Employee name: " << employeeName << endl;
    //     // getline(cin, employeeName);

    //     cout << "Salary: "<<salary<<endl;
    //     // cin >> salary;

    //     cout << "No. of Leaves: " << noOfLeave << endl;
    // }

    // virtual double calcSalary() = 0;
