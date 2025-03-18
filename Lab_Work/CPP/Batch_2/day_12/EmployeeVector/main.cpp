#include <iostream>
#include "emp_header.h"
#include "address_header.h"
#include "emp_mgr.h"

using namespace std;

int main()
{
	int eid;
	string area, city, pin, name;
	double salary;

	cout << "Enter employee id: " << endl;
	cin >> eid;
	cin.ignore();
	cout << "Enter employee's name: " << endl;
	getline(cin, name);
	cout << "Enter Address (area, City, pincode):\n";
	getline(cin, area);
	getline(cin, city);
	getline(cin, pin);
	// cin.ignore();

	cout << "Enter salary: " << endl;
	cin >> salary;
	cin.ignore();

	Address address(area, city, pin);

	Employee e1(eid, name, address, salary);
	e1.displayEmployees();

	EmpMgr emgr;
	emgr.addEmployee(e1);
	emgr.displayEmployees();

	return 0;
}
