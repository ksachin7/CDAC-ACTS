#include<iostream>
using namespace std;

void oddEven(int n){
	if(n%2 == 0){
		cout<<"The given number is Even.";
	}
	else{
		cout<<"The given number is Odd.";
	}
}

int main(){
	int num;

	cout<<"Enter a number: ";
	cin>>num;

	oddEven(num);
}
