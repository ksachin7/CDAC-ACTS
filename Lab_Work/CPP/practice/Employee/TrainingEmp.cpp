// ii. If he/she is from Training employees then
// - Company has given 2 Paid Leaves for employee. If he/she has taken leaves more than paid leaves
// then deduct salary accoraingly.
// - Consider 900 rupees per lecture session
// - extra 400 rupees per lab session (if he/she attended the lab)
// - calculate total salary for month.
#include<iostream>
#include<stdexcept>
#include"TrainingEmp.h"
#include"LeaveException.cpp"
using namespace std;

	TrainingEmp::TrainingEmp(const string &companyName, const string &employeeName, double salary, int noOfLeave, int noOfLectureSession, int noOfLabSession):Employee(companyName, employeeName, salary, noOfLeave), noOfLectureSession(noOfLectureSession), noOfLabSession(noOfLabSession){}

	double TrainingEmp::calculateSalary(){
		const int paidLeave= 2;
		const double perLectureSalary= 900;
	    double leaveDeduction = 0.0;
		const int salaryPerLabSession=400;

		if(noOfLeave <0 || noOfLectureSession <0 || noOfLabSession <0){
			throw LeaveException("Leave count or Employee hire count can't be negative!");
		}

		if(noOfLeave > paidLeave){
			leaveDeduction= (noOfLeave-paidLeave)*perLectureSalary;
		}

		salary= (perLectureSalary * 31) -leaveDeduction + salaryPerLabSession;
		return salary;
	}

	void TrainingEmp::display()
    {
    	cout<<"----------------------------------------"<<endl;
        cout << "Company name: " << companyName << endl;
        // getline(cin, companyName);

        cout << "Employee name: " << employeeName << endl;
        // getline(cin, employeeName);

        cout << "Salary: "<<salary<<endl;
        // cin >> salary;

        cout << "No. of Leaves: " << noOfLeave << endl;
        cout<<"No of lecture sessions: "<<noOfLectureSession<<endl;
        cout<<"No of Lab sessions: "<<noOfLabSession<<endl;
        cout<<"----------------------------------------"<<endl;
    }
