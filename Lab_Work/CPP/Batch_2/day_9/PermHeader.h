#ifndef PERM_EMPLOYEE_HEADER_H_
#define PERM_EMPLOYEE_HEADER_H_

#include<iostream>
#include"EmployeeHeader.h"

  using namespace std;

  class PermEmployee: public Employee{
    private:
      int bonus;
		  int noOfExp;
  
    public:
    PermEmployee();
    // PermEmployee(int bonus, int noOfExp);
    PermEmployee(string name, double salary, int noOfExp);

    virtual double CalcSalary();
    virtual void Accept();
    // virtual void Accept(string name, double salary);
    virtual void Display();
  };
  
 #endif
 
 
 
 
 
 
 
 
 
 

