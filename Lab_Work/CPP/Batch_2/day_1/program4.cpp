#include<iostream>
using namespace std;

int main(){

	int b, e, v=1;

	cout<<"Enter base number: ";
	cin>>b;

	cout<<"Enter exponent: ";
	cin>>e;

	for(int i=0; i<e; i++){
		v *= b;
	}

	cout << b << "^" << e << " is: " << v << endl;

	return 0;
}

