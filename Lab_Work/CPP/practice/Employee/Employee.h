#ifndef _EMP_H
#define _EMP_H

#include <iostream>
#include <string>

using namespace std;
class Employee
{
protected:
    string companyName;
    string employeeName;
    double salary;
    int noOfLeave;

public:
    // Employee(){}
    Employee(const string &companyName, const string &employeeName, double salary, int noOfLeave);

    virtual void display()=0;
    virtual double calculateSalary() = 0;
};

#endif