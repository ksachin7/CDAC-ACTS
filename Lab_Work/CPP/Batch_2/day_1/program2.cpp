#include<iostream>
#include<string>
using namespace std;

int main(){

	char a, b;

	cout<<"Enter a char: ";
	cin>> a;
	cout<<"Enter another char: ";
	cin>> b;
	
	cout<<"The ASCII result of addition of two chars: "<< a+b <<endl;

	cout<<"The concatenated string of chars is"<<string(1, a)+string(1,b)<<endl;

	return 0;
}
