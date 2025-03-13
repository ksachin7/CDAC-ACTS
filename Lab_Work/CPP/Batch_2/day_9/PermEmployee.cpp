#include<iostream>
#include<string>
#include"PermHeader.h"
#include"EmployeeHeader.h"

using namespace std;
        // PermEmployee::PermEmployee():bonus(0), noOfExp(0){}
        // PermEmployee::PermEmployee(int bonus, int noOfExp): bonus(bonus), noOfExp(noOfExp){}

        PermEmployee::PermEmployee() : Employee(), noOfExp(0) {}

        PermEmployee::PermEmployee(string name, double salary, int noOfExp)
            : Employee(name, salary), noOfExp(noOfExp) {}


void PermEmployee::Accept() {
        Employee::Accept();
        // Employee::Accept(name, salary);
        // cout<<"Enter bonus: " << this->bonus<<endl;
        // cin>>bonus;

        cout<<"Enter noOfExp: "<<endl;
        cin>>this->noOfExp;
  }

// void PermEmployee::Accept(string name, double salary) {
//         Employee::Accept(name, salary);
//         // cout<<"Enter bonus: " << this->bonus<<endl;
//         // cin>>bonus;

//         cout<<"Enter noOfExp: "<<endl;
//         cin>>this->noOfExp;
// }

 void PermEmployee::Display() {
        cout<<"+----------------------------+"<<endl;
        Employee::Display();
        // cout<<"Bonus: "<<this->bonus<<endl;
        cout<<"No of Experiance: "<<this->noOfExp<<endl;
        cout<<"Salary: "<<CalcSalary()<<endl;
        cout<<"Type: Permanent Employee"<<endl;
        cout<<"+----------------------------+"<<endl;
 } 

double PermEmployee::CalcSalary() {
        this->bonus = getSalary() * 0.1;  // 10% performance bonus
        double experienceBonus = 0.01 * (noOfExp - 3) * getSalary();  // 1% per year over 3 years of experience

        return getSalary() + bonus + experienceBonus;  // Base Salary + Bonus + Experience Bonus
}
