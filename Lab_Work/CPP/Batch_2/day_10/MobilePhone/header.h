#ifndef MOBILEPHONE_H
#define MOBILEPHONE_H


#include<iostream>
#include<string>
#include <fstream>
using namespace std;

class MobilePhone{
	private:
        int serialNo; 
        string modelNo;
        string brandName;
        double price;

	public:
		int getSerialNo() const { return serialNo; }
    	string getModelNo() const { return modelNo; }
	    string getBrandName() const { return brandName; }
	    double getPrice() const { return price; }

		// Setter functions
		void setSerialNo(int sn) { serialNo = sn; }
		void setModelNo(const string& model) { modelNo = model; }
		void setBrandName(const string& brand) { brandName = brand; }
		void setPrice(double p) { price = p; }

		MobilePhone();
		void Accept();
		void Display() const;

	friend ostream& operator<<(ostream& os, const MobilePhone& phone);
    friend istream& operator>>(istream& is, MobilePhone& phone);
};

int fileToArray(const string& fileName, MobilePhone* phoneArr, int& n);

void SortByPrice(MobilePhone* arr, int n);

#endif