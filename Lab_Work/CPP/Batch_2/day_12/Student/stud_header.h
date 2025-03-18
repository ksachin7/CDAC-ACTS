#ifndef STUDENT_H
#define STUDENT_H

#include <iostream>
#include "address_header.h"
using namespace std;

class Student
{
private:
	int rno;
	string name;
	Address *permanentAddress;
	Address *currentAddress;

public:
	// Student(int rno, string name, string a1, string c1, string p1, string a2, string c2, string p2);
	Student(int rno, const string &name, Address *permanentAddress, Address *currentAddress);
	~Student();

	void printStudentInfo() const;
};

#endif