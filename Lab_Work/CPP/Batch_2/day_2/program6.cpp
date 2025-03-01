#include<iostream>
#include<string>
#include<cmath>

using namespace std;


void findQuadraticRoots(int a, int b, int c){

	double d= b*b - 4*a*c;

	if(d>0){
		double root1= -b+sqrt(d)/2*a;
		double root2= -b-sqrt(d)/2*a;

		cout<<"The roots are real and distinct: "<< root1 <<" "<< root2;
	}
	else if(d == 0){
        double root = -b/(2 * a);
        cout << "One real root: " << root << endl;
	}
	else{
		cout<<"Roots are complex!";
	}
}

int main(){
	char x;
	int a, b, c;
	// string eqn= "7*x*x+8*x-11";
	cout<<"Please enter values of a, b & c for a Quadratic equation: "<<endl;
	cin>> a >> b >> c;

	cout<<"The given equation is: "<<a<<"x^2 + "<<b<<"x + "<<c<<endl;
	findQuadraticRoots(a, b, c);

	return 0;
}
