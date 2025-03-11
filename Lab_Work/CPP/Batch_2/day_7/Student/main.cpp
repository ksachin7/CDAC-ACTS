#include <iostream>
#include "Student.h"

using namespace std;

int main() {
    Student s1("Alice");
    Student s2("Bob");
    Student s3("Charlie");

    s1.display();
    s2.display();
    s3.display();

    cout << "Total number of students created: " << Student::getStudentCount() << endl;

    return 0;
}
