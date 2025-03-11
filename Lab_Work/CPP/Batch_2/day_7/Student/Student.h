#ifndef STUDENT_H
#define STUDENT_H

#include <string>
using namespace std;

class Student {
private:
    static int studentCount;
    int rollNumber;
    string name;

public:
    // Constructors
    Student();
    Student(string name);

    // Methods
    void display() const;

    static int getStudentCount();
};

#endif
