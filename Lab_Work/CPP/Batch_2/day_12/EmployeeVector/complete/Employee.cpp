#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Address
{
protected:
    string area;
    string city;
    string pincode;

public:
    Address(const string &area, const string &city, const string &pincode) : area(area), city(city), pincode(pincode) {}

    void setAddress(const string &area, const string &city, const string &pincode)
    {
        this->area = area;
        this->city = city;
        this->pincode = pincode;
    }
    void displayAddress() const
    {
        cout << area << ", " << city << ", " << pincode;
    }
};

class Employee
{
protected:
    int eid;
    string name;
    Address address;
    double salary;

public:
    // Employee() : eid(0), name("Unknown"), address(Address()), salary(0.0) {}
    Employee(int eid, const string &name, const Address &address, double salary) : eid(eid), name(name), address(address), salary(salary) {}

    int getEid() const
    {
        return eid;
    }

    void setAddress(const string &area, const string &city, const string &pincode)
    {
        address = Address(area, city, pincode);
    }

    void Accept()
    {
        cout << "Enter eid: " << endl;
        cin >> eid;
        cin.ignore();

        cout << "Enter name: " << endl;
        getline(cin, name);

        cout << "Enter address(area, city, pincode): " << endl;
        string area, city, pincode;
        cin.ignore();
        getline(cin, area);
        getline(cin, city);
        getline(cin, pincode);
        setAddress(area, city, pincode);

        // cin.ignore();
        cout << "Enter salary: " << endl;
        cin >> salary;
        cin.ignore(); // Ignore the newline left in the buffer after the salary input
    }
    void displayEmployees() const
    {
        cout << "Employee ID: " << eid << endl;
        cout << "Employee Name: " << name << endl;
        cout << "Employee Salary: " << salary << endl;
        cout << "Employee Address: ";
        address.displayAddress();
        cout << endl;
    }
};

class EmpMgr
{
protected:
    vector<Employee> employees;

public:
    void addEmployee(const Employee &emp)
    {
        employees.push_back(emp);
        cout << "Employee added successfully!" << endl;
    }

    void modifyEmployee(int eid)
    {
        auto it = employees.begin();
        while (it != employees.end())
        {
            if (it->getEid() == eid)
            {
                string newName, area, city, pincode;
                double newSalary;
                cout << "Enter a new name: " << endl;
                getline(cin, newName);

                cout << "Enter salary: " << endl;
                cin >> newSalary;

                cout << "Enter new address: " << endl;
                cin.ignore();
                getline(cin, area);
                getline(cin, city);
                getline(cin, pincode);

                it->setAddress(area, city, pincode);

                cout << "Employee details modified successfully!" << endl;

                return;
            }
            ++it;
        }
    }

    void searchEmployee(int eid)
    {
        auto it = employees.begin();
        while (it != employees.end())
        {
            if (it->getEid() == eid)
            {
                it->displayEmployees();
                return;
            }
            ++it;
        }
        cout << "Employee with ID " << eid << " not found!" << endl;
    }

    void deleteEmployee(int eid)
    {
        // Manually iterate through the employees and find the matching employee by id
        auto it = employees.begin();
        while (it != employees.end())
        {
            if (it->getEid() == eid)
            {
                employees.erase(it);
                cout << "Employee with ID " << eid << " deleted." << endl;
                return;
            }
            ++it;
        }

        cout << "Employee not found!" << endl;
    }

    void displayEmployees()
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
};

int main()
{
    EmpMgr emgr;
    int eid;
    int choice;
    cout << "Please enter a choice: " << endl;
    do
    {
        cout << "1. add employee" << endl;
        cout << "2. display employee" << endl;
        cout << "3. modify employee" << endl;
        cout << "4. delete employee" << endl;
        cout << "5. exit" << endl;
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            // Employee e1; // Creating a dummy employee
            Employee e1(0, "", Address("", "", ""), 0); // Creating a dummy employee
            e1.Accept();

            emgr.addEmployee(e1);
            break;
        }
        case 2:
            emgr.displayEmployees();
            break;
        case 3:
        {
            cout << "Enter Employee ID to modify: ";
            cin >> eid;
            emgr.modifyEmployee(eid);
            break;
        }
        case 4:
        {
            int eid;
            cout << "Enter Employee ID to modify: ";
            cin >> eid;
            emgr.deleteEmployee(eid);
            break;
        }
        case 5:
            cout << "Exiting program." << endl;
            break;
        default:
            cout << "Invalid Input! Please enter a valid choice!" << endl;
            break;
        }
    } while (choice != 5);
    return 0;
}