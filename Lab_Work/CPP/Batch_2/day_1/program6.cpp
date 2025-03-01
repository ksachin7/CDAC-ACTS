#include<iostream>
using namespace std;

void areaOfRectangle(int l,int b){
	cout<<"Area of rectangle is: " <<l*b;
}

int main(){
	int l,b;
	cout<<"Enter length of rectangle: ";
	cin>>l;

	cout<<"Enter breadth of rectangle: ";
	cin>>b;

	areaOfRectangle(l,b);

	return 0;
}
