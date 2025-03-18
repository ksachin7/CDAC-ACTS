#include<iostream>
using namespace std;

template<class T>

void Swap(T &a, T &b){
	T tmp;
	tmp= a;
	a=b;
	b=tmp;
}

template<class T>
double add(T &a, T &b){
	return a+b;
}

template<class T>
double substract(T &a, T &b){
	return a-b;
}

template<class T>
double multiplication(T &a, T &b){
	return a*b;
}

template<class T>
double division(T &a, T &b){
	return (double)a/b;
}


int main(){

	
	int a=20, b=30;
	float c=15, d=45;	
	cout<<"a: "<<a<<"\nb: "<<b<<"\nc: "<<c<<"\nd: "<<d<<endl;	

	Swap(a, b);
	cout<<"a: "<<a<<" b: "<<b<<endl;
	swap(c, d);
	cout<<"c: "<<c<<" d: "<<d<<endl;

	cout<<"Addition of a and b is: "<<add(a,b)<<endl;
	cout<<"Addition of c and d is: "<<add(c,d)<<endl;
	
	cout<<"Substraction of a and b is: "<<substract(a,b)<<endl;
	cout<<"Multiplication of c and d is: "<<multiplication(c,d)<<endl;

	cout<<"Division of a and b is: "<<division(a,b);	

return 0;
}
