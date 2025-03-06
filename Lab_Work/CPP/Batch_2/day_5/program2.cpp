#include<iostream>
using namespace std;

int findFactorial(int n){
	if(n== 0)
		return 1;
	return n*findFactorial(n-1);
}

int main(){
	int n;

	cout<<"Enter a no.: ";
	cin>>n;

	cout<<"The factorial of "<<n<<" is: "<<findFactorial(n);
}
