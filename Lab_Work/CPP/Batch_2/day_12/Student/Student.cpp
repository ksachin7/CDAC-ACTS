#include <iostream>
#include "stud_header.h"
using namespace std;

// Student::Student(int rno, string name, string a1, string c1, string p1, string a2, string c2, string p2) : rno(rno), name(name), permanentAddress(a1, c1, p1), currentAddress(a2, c2, p2) {}
Student::Student(int rno, const string &name, Address *permanentAddress, Address *currentAddress)
	: rno(rno), name(name), permanentAddress(permanentAddress), currentAddress(currentAddress) {}
Student::~Student() {}

void Student::printStudentInfo() const
{
	cout << "\nRoll No: " << rno << "\nName: " << name;

	cout << "\nPermanent Address: ";
	permanentAddress->displayAddress();

	cout << "\nCurrent Address: ";
	currentAddress->displayAddress();
}
