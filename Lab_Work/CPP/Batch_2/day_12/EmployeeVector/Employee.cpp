#include <iostream>
#include <vector>
#include <string>

#include "emp_header.h"
#include "address_header.h"

using namespace std;

// Employee::Employee() {}
Employee::Employee(int eid, const string &name, Address &address, double salary) : eid(eid), name(name), address(address), salary(salary) {}

void Employee::displayEmployees() const
{
	cout << "Employee ID: " << eid << endl;
	cout << "Employee Name: " << name << endl;
	cout << "Employee Salary: " << salary << endl;
	cout << "Employee Address: ";
	address.displayAddress();
}
