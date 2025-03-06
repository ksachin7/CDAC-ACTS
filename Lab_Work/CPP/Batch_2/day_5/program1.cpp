#include<iostream>
using namespace std;

void printStudents(int *arr, int n){
	cout<<"Roll no. of Students are: ";
	for(int i=0; i<n; i++){
		cout<<arr[i]<< " ";
	}
}

int main(){
	int n;
	cout<<"Enter array size: ";
	cin>>n;

	int student[n];

	cout<<"Enter array Elements: ";
	for(int i=0; i<n; i++){
		cin>>student[i];
	}

	printStudents(student, n);

	return 0;
}
