#include<iostream>
using namespace std;

void swapNum(int *a, int *b){
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

int main(){
	int num1,num2;
	cout<<"Enter First Number: ";
	cin>>num1;
	cout<<"Enter Second Number: ";
	cin>>num2;

	cout<<"before swap num1 is: "<<num1<<", num2 is: "<<num2<<endl;
	swapNum(&num1,&num2);
	cout<<"After Swap num1 is: "<<num1<<", num2 is: "<< num2<<endl;

	return 0;
}
