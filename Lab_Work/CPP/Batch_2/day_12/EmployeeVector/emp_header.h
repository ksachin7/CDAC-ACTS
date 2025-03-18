#ifndef EMP_HEADER_H_
#define EMP_HEADER_H_

#include <iostream>
#include <vector>
#include <string>
#include "address_header.h"

using namespace std;

class Employee
{
protected:
	int eid;
	string name;
	Address address;
	double salary;

public:
	Employee();
	Employee(int eid, const string &name, Address &address, double salary);

	void displayEmployees() const;
};

#endif