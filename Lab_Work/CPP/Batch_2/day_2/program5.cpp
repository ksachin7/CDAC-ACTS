#include<iostream>
using namespace std;

int sumOfNum(int n){
	int sum=0;
	if(n<=1)
		return 1;
	return sumOfNum(n-1)+n;
}

int main(){
	int num;

	cout<<"Enter a number: ";
	cin>>num;

	cout<<"The sum of numbers are: "<<sumOfNum(num)<<endl;
	
	return 0;
}
