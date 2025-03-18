#include <iostream>
#include "stud_header.h"

using namespace std;

int main()
{
	// Student *student1 = new Student(1, "student1", "abc", "city", "10001", "def", "city", "20020");
	// Student *student1 = new Student(1, "student2", "abc", "city", "10001", "def", "city", "20020");
	// student1->printStudent();
	// cout << endl;

	Address *permAddress = new Address("123 Main St", "xyz", "61100");
	Address *currAddress = new Address("456 Elm St", "abc", "61101");

	Student student(101, "Student1", permAddress, currAddress);

	student.printStudentInfo();

	return 0;
}
