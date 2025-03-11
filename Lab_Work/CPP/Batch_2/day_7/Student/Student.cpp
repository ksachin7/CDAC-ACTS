#include "Student.h"
#include <iostream>
using namespace std;

int Student::studentCount = 0;

Student::Student() {
    rollNumber = ++studentCount;
    name = "Unknown";
}

Student::Student(string name) {
    rollNumber = ++studentCount;
    this->name = name;
}

void Student::display() const {
    cout << "Roll Number: " << rollNumber << ", Name: " << name << endl;
}

int Student::getStudentCount() {
    return studentCount;
}
