#include<iostream>
using namespace std;

void factorial(int num){
	int fact=1;

	for(int i=1; i<=num; i++){
	    for(int j=i; j>0; j--){
		    fact*=j;
	    }
	    cout<<fact<<" ";
	    fact=1;
	}
}

int main(){
	int num,fact;
	
	cout<<"Enter a number: ";
	cin>>num;

	factorial(num);

	return 0;
}
