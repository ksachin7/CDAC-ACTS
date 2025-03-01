#include<iostream>
using namespace std;

double area_of_circle(int r){
	return 3.14*r*r;

}

double area_of_rectangle(int l, int b){
	return l*b;
}

double area_of_square(int l){
	return l*l;
}

int main(){
	char ch;
	int r, l, b;
	cout<<"Enter c for area of a circle, r for area of a rectangle, s for area of a squre.";
	cin>>ch;

	switch(ch){
		case 'c':
		{
			cout<<"Please enter the radious: ";
			cin>>r;
			cout<<area_of_circle(r)<<endl;
			break;
		 }
		case 'r':
		{
			cout<<"Please enter length and breadth: ";
			cin>>l;
			cin>>b;
			cout<<area_of_rectangle(l, b)<<endl;
		}
		case 's':
		{	
			cout<<"Please enter the side length: ";
                        cin>>l;
			cout<<area_of_square(l)<<endl;
			break;
		}
		default: cout<<"Invalid Input!"<< endl;
	}
}
