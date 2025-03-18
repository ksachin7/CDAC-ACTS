#include <iostream>
#include "emp_header.h"
#include "emp_mgr.h"
using namespace std;

void EmpMgr::addEmployee(const Employee &emp)
{
    employees.push_back(emp);
    cout << "Employee added successfully!" << endl;
}

// void EmpMgr::deleteEmployee(int eid)
// {
//     employees.erase(find(employees.begin(), employees.end(), eid));
//     cout << "Employee deleted successfully!" << endl;
// }
void EmpMgr::deleteEmployee(int eid)
{
    // Manually iterate through the employees and find the matching employee by id
    auto it = employees.begin();
    while (it != employees.end())
    {
        if (it->Employee::eid == eid)
        {
            employees.erase(it);
            cout << "Employee with ID " << eid << " deleted." << endl;
            return;
        }
        ++it;
    }

    cout << "Employee not found!" << endl;
}

void EmpMgr::displayEmployees()
{
    if (employees.empty())
    {
        cout << "No employee records found!" << endl;
        return;
    }

    // for (const Employee &emp : employees)
    // {
    //     emp.displayEmployees();
    //     cout << "\n-----------------------------" << endl;
    // }

    for (int i = 0; i < employees.size(); ++i)
    {
        Employee &emp = employees[i];
        emp.displayEmployees();
    }
}
