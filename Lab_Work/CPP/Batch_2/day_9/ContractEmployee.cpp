#include<iostream>
#include<string>
#include"ContractHeader.h"
#include"EmployeeHeader.h"
using namespace std;

	ContractEmployee::ContractEmployee(): Employee(), noOfYears(0) {}
	// ContractEmployee::ContractEmployee(int bonus, int noOfYears):bonus(bonus), noOfYears(noOfYears){}
	ContractEmployee::ContractEmployee(string name, double salary, int noOfYears): Employee(name, salary), noOfYears(noOfYears) {}

	void ContractEmployee::Accept(){
        Employee::Accept();
        // Employee::Accept(name, salary);
        // Set the base class values using setters
	    // this->setEid(eid);
	    // this->setName(name);
	    // this->setSalary(salary);

		// cout<<"Enter bonus: " << bonus<<endl;
		// cin>>bonus;

		cout<<"Enter noOfExp: "<<endl;
		cin>>noOfYears;
     }
  
    void ContractEmployee::Display(){
    	cout<<"+----------------------------+"<<endl;
		Employee::Display();
        // cout<<"bonus: "<< bonus<<endl;
		cout<<"No of Years: "<< noOfYears<<endl;
		cout<<"Salary: "<< CalcSalary()<<endl;
		cout<<"Type: Contract Employee"<<endl;
		cout<<"+----------------------------+"<<endl;
    }


	double ContractEmployee::CalcSalary(){
		this->bonus = getSalary() * 0.2;  // 20% contract bonus
	    double contractDurationBonus = 0;

	    if (noOfYears >= 2) {
	        contractDurationBonus = getSalary() * 0.05;  // 5% bonus for a 2+ year contract
	    }

	    return getSalary() + bonus + contractDurationBonus;  // Base Salary + Contract Bonus + Duration Bonus
	}
