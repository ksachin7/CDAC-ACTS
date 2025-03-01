#include<iostream>
#include<cmath>
using namespace std;

int main(){
	double p,r,t,n,CI;

	cout<<"Enter Principal amount\n";
	cin>> p;

	cout<<"Enter rate of intrerst\n";
	cin>>r;

	cout<<"Enter No. of times intrest is compounded per year:\n";
	cin>>n;

	cout<<"Enter time in years\n";
	cin>>t;

	r/=100;
	CI= p*pow((1+r/n), n*t);

	
	cout<<"The compound intrest is: " << CI << endl;
	return 0;
}
