#include<iostream>
#include "header.h"
#include <sstream> 
using namespace std;

MobilePhone::MobilePhone(){
	this->serialNo= 0;
	this->modelNo= "";
	this->brandName= "";
	this->price= 0;
}

void MobilePhone::Accept(){
	cout<<"Enter serial no: "<<endl;
	cin>>serialNo;

    cin.ignore(numeric_limits<streamsize>::max(), '\n'); 

	cout<<"Enter model no: "<<endl;
	getline(cin, modelNo);

	cout<<"Enter Brand name: "<<endl;
	getline(cin, brandName);

	cout<<"Enter price: "<<endl;
	cin>>price;
}

void MobilePhone::Display() const{
	cout<<"Serial No: "<<this->serialNo<<", ";
	cout<<"Model No: "<<this->modelNo<<", ";
	cout<<"Brand: "<<this->brandName<<", ";
	cout<<"Price: "<<this->price<<endl;
}

int fileToArray(const string& fileName, MobilePhone* phoneArr, int& n) {
    ifstream fin(fileName, ios::binary);  // Open the binary file for reading

    if (!fin) {
		cout<<"\n File Not found"<<endl;
        return -1;
    }
	cout<<"\n Records from file: "<<endl;
	int i=0;

	// Read each MobilePhone object from the binary file
	while(fin.read((char*)&phoneArr[i],sizeof(MobilePhone))){
			// phoneArr[i].Display();	
			i++;
	}
	n=i;
	
	fin.close();

    return n;  
}

void SortByPrice(MobilePhone* arr, int n){
	for(int i=0; i<n-1; i++){
		for(int j=0; j<n-i-1; j++){

			if(arr[j].getPrice() > arr[j+1].getPrice())
				swap(arr[j], arr[j+1]);
		}
	}
}