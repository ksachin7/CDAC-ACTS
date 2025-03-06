#include<iostream>
#include<string>
using namespace std;

class Employee{
	int empNo;
	string name;
	double salary;
	string dept;

public:

	Employee(){
		empNo=0;
		name="";
		salary=0.00;
		dept="";
	}

	Employee(int empNo, string name, double salary, string dept){
		this->empNo= empNo;
		this->name= name;
		this->salary= salary;
		this->dept= dept;
	}

	void acceptEmployee(){
		cout << "Enter Employee Number: ";
        cin >> empNo;
        cin.ignore();  // To clear the newline character after entering empNo

        cout << "Enter Name: ";
        getline(cin, name);

        cout << "Enter Salary: ";
        cin >> salary;
	}

	int getEmpNo() const{
		return empNo;
	}

	string getName() const{
		return name;
	}

	double getSalary() const{
		return salary;
	}

	string getDepartment() const{
		return dept;
	}

	void displayEmployee(){
        printf("EmpNo: %d, Name: %s, Salary: %.2f\n", empNo, name.c_str(), salary);
	}
};

void sortEmployee(Employee employees[], int n, const string& field){
		for(int i=0; i<n-1; i++){
			for (int j = 0; j < n-i-1; j++){
            bool swapFlag = false;

				if(field == "empNo"){
					if (employees[j].getEmpNo() > employees[j+1].getEmpNo()){
                    	swapFlag = true;
					}
				}

				else if(field == "name"){
					if (employees[j].getName() > employees[j+1].getName()){
                    	swapFlag = true;
					}
				}

				else if(field == "salary"){
					if (employees[j].getSalary() > employees[j+1].getSalary()){
                    	swapFlag = true;
					}
				}

				if (swapFlag) {
                	swap(employees[j], employees[j + 1]);
            	}
			}
		}

	}

int main(){

	int n;

	cout<<"Enter no. of employees: "<<endl;
	cin>>n;

	Employee employees[n];

	for (int i = 0; i < n; i++)
	{
		cout<<"\nEnter details of employee "<<i+1<<":"<<endl;
		employees[i].acceptEmployee();
	}

    cout << "\n\nEmployees are:" << endl;
	for (int i = 0; i < n; i++)
	{
		employees[i].displayEmployee();
	}

	// Sorting by name
    cout << "\nSorting by name:" << endl;
	sortEmployee(employees, n, "name");
	for (int i = 0; i < n; i++)
	{
		employees[i].displayEmployee();
	}

	// Sorting by empNo
    cout << "\nSorting by empNo:" << endl;
    sortEmployee(employees, n, "empNo");
    for (int i = 0; i < n; i++) {
        employees[i].displayEmployee();
    }

    // Sorting by salary
    cout << "\nSorting by salary:" << endl;
    sortEmployee(employees, n, "salary");
    for (int i = 0; i < n; i++) {
        employees[i].displayEmployee();
    }

	return 0;
}