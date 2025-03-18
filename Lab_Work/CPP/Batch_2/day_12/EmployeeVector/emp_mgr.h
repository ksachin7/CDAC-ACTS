#include <iostream>
#include "emp_header.h"
using namespace std;

class EmpMgr
{
protected:
    vector<Employee> employees;

public:
    void addEmployee(const Employee &emp);
    void deleteEmployee(int eid);
    void displayEmployees();
};
