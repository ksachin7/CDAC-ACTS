#ifndef _EMPLOYEE_HEADER_H_
#define _EMPLOYEE_HEADER_H_

#include<iostream>
#include<string>
using namespace std;

class Employee{

	private:
		int eid;
		string name;
		double salary;
		static int nextId;

	public:
		Employee();
		Employee(const string &name, double salary);

		virtual ~Employee() {} // Virtual destructor to ensure proper cleanup

		int getEid() const{
			return eid;
		}

		// void setEid(int eid){
		// 	this->eid = eid;
		// }

		string getName() const{
			return name;
		}

		void setName(const string &name){
			this-> name = name;
		}

		  double getSalary() const {
	        return salary;
	    }

	    void setSalary(double salary) {
	        this->salary = salary;
	    }

		virtual double CalcSalary() = 0;
		// virtual void Accept(string name, double salary)=0;
		virtual void Accept()=0;
		virtual void Display();
};

#endif

