#include <iostream>
#include <string>
#include "EmployeeHeader.h"

using namespace std;

int Employee::nextId = 1;

Employee::Employee() : name(""), salary(0.0)
{
	eid = nextId++;
}

Employee::Employee(const string &name, double salary) : name(name), salary(salary)
{
	eid = nextId++;
}

double Employee::CalcSalary()
{
	return salary;
}

void Employee::Accept()
{
	this->eid = nextId++;
	cin >> name;
	cin >> salary;
}

// void Employee::Accept(string name, double salary){
// 	this->eid= nextId++;
// 	this->name= name;
// 	this->salary= salary;
// }

void Employee::Display()
{
	cout << "Employee ID: " << eid << endl;
	cout << "Employee Name: " << name << endl;
	cout << "Basic Salary: " << salary << endl;
}
