#ifndef ADDRESS_H
#define ADDRESS_H

#include <iostream>
#include <string>
using namespace std;

class Address
{
private:
	string area;
	string city;
	string pincode;

public:
	Address(const string &area, const string &city, const string &pincode);

	void displayAddress() const;
};

#endif