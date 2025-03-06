#include<iostream>
#include<cmath>
using namespace std;


void primeNumbers(int n){
	bool isPrime = true;

	if(n<0) {
		cout<< "Invalid Input!";
		return;
	}

	for(int i=2; i <= n; i++)
	{
		for(int j= 3; j <= sqrt(n); j+=2)
		{
			if(i % j == 0)
			{
				isPrime= false;
				break;
			}
		}
		if(isPrime)
			cout<< i << " ";
	}
}

int main(){
	int n;

	cout<<"Enter a number: ";
	cin>>n;

	primeNumbers(n);

	return 0;
}