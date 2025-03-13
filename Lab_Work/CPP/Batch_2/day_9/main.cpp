#include<iostream>
#include"EmployeeHeader.h"
#include"PermHeader.h"
#include"ContractHeader.h"
using namespace std;

int main(){
	// Employee e; // // Error: Cannot instantiate abstract class
    
    // Create objects of the derived classes
    PermEmployee pe("Alice", 50000, 5);     // Permanent Employee with bonus
    ContractEmployee ce("Bob", 30000, 2);   // Contract Employee with duration in months

    // Create a base class pointer to demonstrate polymorphism
    Employee* emp;

    // Point to PermanentEmployee object and call getSalary() dynamically
    emp = &pe;
    emp->Display();

    cout << endl;

    // Point to ContractEmployee object and call getSalary() dynamically
    emp = &ce;
    emp->Display();

	return 0;
}
