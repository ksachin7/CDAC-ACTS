#include<iostream>
using namespace std;

int main(){
	char ch;
	cout<<"Enter a char: ";
	cin>>ch;

	
	if(ch>=65 && ch<=90)
		cout<<"The entred char is a Capital letter."<<endl;
	else if(ch>=97 && ch<=122)
		cout<<"Entred char is a small letter"<<endl;
	else
		cout<<"Not an alphabet char!"<<endl;

	return 0;
}
