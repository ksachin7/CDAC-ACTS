#ifndef _TRAINING_H
#define _TRAINING_H

#include<iostream>
#include<stdexcept>
#include"Employee.h"

using namespace std;

class TrainingEmp: public Employee{
protected:
	int noOfLectureSession;
	int noOfLabSession;

public:

	TrainingEmp(const string &companyName, const string &employeeName, double salary, int noOfLeave, int noOfLectureSession, int noOfLabSession);

	double calculateSalary();
	void display();
};

#endif