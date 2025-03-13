#ifndef CONTRACT_EMPLOYEE_HEADER_H_
#define CONTRACT_EMPLOYEE_HEADER_H_
   
#include<iostream>
#include"EmployeeHeader.h"
using namespace std;

class ContractEmployee : public Employee {
       private:
            int bonus;
            int noOfYears;
            
       public:
		ContractEmployee();
		// ContractEmployee(int bonus, int noOfYears);
	    	ContractEmployee(string name, double salary, int noOfYears);

		virtual double CalcSalary(); 
		virtual void Accept();
		// virtual void Accept(string name, double salary);
		virtual void Display(); 
};
    
#endif
