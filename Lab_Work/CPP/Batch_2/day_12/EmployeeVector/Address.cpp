#include <iostream>
#include "address_header.h"

Address::Address(const string &area, const string &city, const string &pincode) : area(area), city(city), pincode(pincode) {}

void Address::displayAddress() const
{
	cout << area << ", " << city << ", " << pincode;
}