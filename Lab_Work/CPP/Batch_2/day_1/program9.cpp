#include<iostream>
using namespace std;

void to_binary(int num){
	if(num >= 1)
		to_binary(num/2);
	cout<< num%2;
}

int main(){
	int num;
	cout<<"Enter a number: ";
	cin>> num;

	to_binary(num);

	return 0;
}

	


