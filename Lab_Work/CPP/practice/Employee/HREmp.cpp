// 3paid leave emp/month(31days)
// deduct slary for more leave

// salary 1250/day

// after hiring new employee he/she should get 500 rupees/employee as incentive.
// - calculate total salary for month
#include<iostream>
#include"HREmp.h"
#include"LeaveException.cpp"
using namespace std;


	HREmp::HREmp(const string &companyName, const string &employeeName, double salary, int noOfLeave, int noOfEmployeeHired): Employee(companyName, employeeName, salary, noOfLeave), noOfEmployeeHired(noOfEmployeeHired){}

	double HREmp::calculateSalary(){
		const int paidLeave= 3;
		const double salaryPerDay= 1250;
		const int incentive=500;
	    double leaveDeduction = 0.0;

		if(noOfLeave <0 || noOfEmployeeHired <0){
			throw LeaveException("Leave count or Employee hire count can't be negative!");
		}

		if(noOfLeave > paidLeave){
			leaveDeduction= (noOfLeave-paidLeave)*salaryPerDay;
		}

		salary= (salaryPerDay * 31) -leaveDeduction + incentive;
		return salary;
	}

	void HREmp::display()
    {
    	cout<<"----------------------------------------"<<endl;
        cout << "Company name: " << companyName << endl;
        // getline(cin, companyName);

        cout << "Employee name: " << employeeName << endl;
        // getline(cin, employeeName);

        cout << "Salary: "<<salary<<endl;
        // cin >> salary;

        cout << "No. of Leaves: " << noOfLeave << endl;

        cout<<"No of employee hired: "<<noOfEmployeeHired<<endl;
        cout<<"----------------------------------------"<<endl;
    }


