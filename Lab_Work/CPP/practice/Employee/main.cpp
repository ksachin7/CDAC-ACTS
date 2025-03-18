#include<iostream>
#include<exception>
#include"Employee.h"
#include"HREmp.h"
#include"TrainingEmp.h"
#include"LeaveException.cpp"

using namespace std;

int main(){
	
	try{
	// Employee *e;
	
	HREmp *e1= new HREmp("xyz", "emp1", 0, 5, 1000);
	e1->calculateSalary();
	e1->display();

	TrainingEmp *e2= new TrainingEmp("xyz", "emp2", 0, 5, 100, 10);
	e2->calculateSalary();
	e2->display();
	}
	catch(LeaveException& e){
		cout << "Error: " << e.what() << endl;
	}
	
	return 0;
}