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
	cout<<"+-----------------------------------------------------------+"<<endl;
	cout<<"Serial No: "<<this->serialNo<<", ";
	cout<<"Model No: "<<this->modelNo<<", ";
	cout<<"Brand: "<<this->brandName<<", ";
	cout<<"Price: "<<this->price<<endl;
	cout<<"+-----------------------------------------------------------+"<<endl;
}

// overloading << op to write MobilePhone obj to file
ostream& operator<<(ostream& os, const MobilePhone& phone){
	os << phone.serialNo << " " << phone.modelNo << " " << phone.brandName << " " << phone.price;
	return os;
}

// overloading >> op to read MobilePhone obj from file
istream& operator>>(istream& is, MobilePhone& phone){
	is >> phone.serialNo >> phone.modelNo  >> phone.brandName >> phone.price;
	return is;
}

int fileToArray(const string& fileName, MobilePhone* phoneArr, int& n) {
    ifstream fin(fileName);  // Open the file for reading

    if (!fin) {
        cout << "Unable to open file for reading!" << endl;
        return 0;
    }

    int i = 0;
    string line;

    // Read the file line by line and store the data in the phoneArr array
    while (getline(fin, line) && i < n) {
        int serial;
        string model, brand;
        double price;

        // Use a stringstream to parse the line
        stringstream ss(line);
        
        // Extract the individual data values from the string stream
        // don't use space in model and brand
        ss >> serial >> model >> brand >> price;

        // Directly set the values in the MobilePhone object
        phoneArr[i].setSerialNo(serial);
        phoneArr[i].setModelNo(model);
        phoneArr[i].setBrandName(brand);
        phoneArr[i].setPrice(price);

        i++;  // Increment the index
    }

    n = i;  // Update the number of entries read
    fin.close();  // Close the file
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