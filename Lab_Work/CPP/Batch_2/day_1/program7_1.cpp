#include<iostream>
using namespace std;

int sumOfDigitsRecursive(int num){
	if(num==0)
		return 0;
	return num%10+sumOfDigitsRecursive(num/10);
}
int main(){
	int num, sum;
	cout<<"Enter a four digit number: ";
	cin>> num;
	sum= sumOfDigitsRecursive(num);

	cout<<"The sum of "<<num<<" is: "<< sum<< endl;

	return 0;
}
