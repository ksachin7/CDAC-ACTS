#include<iostream>
using namespace std;

bool palindrome(int num){

	int reverse=0, lastDigit=0, originalNum=num;
	string result;

	while(num > 0){
		lastDigit=num%10;
		reverse = reverse *10 + lastDigit;
		num/=10;
	}

	return reverse == originalNum; 
}

int main(){

	int n;

	cout<<"Enter a number to check if its a palindrome: ";
	cin>>n;

	palindrome(n) == 0 ? cout<< n << " isn't a palindrome!": cout<< n <<" is a palindrome!" <<endl;

	return 0;
}