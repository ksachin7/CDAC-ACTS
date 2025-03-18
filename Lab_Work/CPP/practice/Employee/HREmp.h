#ifndef HR_H
#define HR_H

#include<iostream>
#include"Employee.h"
using namespace std;

class HREmp: public Employee{
protected:
	int noOfEmployeeHired;

public:
	// HREmp(){}
	HREmp(const string &companyName, const string &employeeName, double salary, int noOfLeave, int noOfEmployeeHired);

	double calculateSalary();
	void display();
};

#endif