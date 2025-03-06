#include<iostream>
using namespace std;

struct Student{
        char name[50];
        int roll;
};

void Accept(Student *student, int n){

        for(int i=0; i<n; i++){
                cout<< "Enter student name: ";
                cin>>(student+i)->name;

                cout<<"Enter student roll: ";
                cin>>(student+i)->roll;
		
		cout<<endl;
        }
}


void Display(Student *student, int n){
	cout<<"Entered Students are: "<<endl<<endl;

        for(int i=0; i<n; i++){
		cout<<"Name: "<<(student+i)->name<<", Roll No.: "<<(student+i)->roll<<" "<<endl;
        }
}


int main(){
        int n;
        cout<<"Enter number of students: ";
        cin>>n;
	cout<<endl;

        Student student[n];

        Accept(student, n);
        Display(student, n);

        return 0;
}

