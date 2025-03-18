#include <iostream>
#include "address_header.h"

void Address::displayAddress() const
{
	cout << area << ", " << city << ", " << pincode;
}