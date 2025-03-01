#include<iostream>
using namespace std;

int sumofDigits(int num){
	int sum = 0;
	
	while(num>0){
		sum = sum+num%10;
		num/=10;
	}
	return sum;
}

int main(){
	int num;
	cout<<"Enter 4 digit number: ";
	cin>>num;

	int sum;
	sum= sumofDigits(num);

	cout<<"The sum of digits are: "<< sum << endl;

	return 0;
	
}
