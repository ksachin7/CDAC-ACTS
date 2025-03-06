#include<iostream>
#include<string>
using namespace std;


string printString(char *ch,int n){
	string str="";

	for(int i=0;i<n;i++){
		cout<<str+ch[i];
	}

	return str;
}

int main(){
	int n;
	
	cout<<"Enter number of character:";
	cin>>n;
	
	cout<<endl;
	
	char ch[n];
	cout<<"Enter characters: ";
	for(int i=0;i<n;i++){
		cin>>ch[i];
	}

	cout<<"The string of concatenated chars is: "<<printString(ch,n)<<endl;
	return 0;
}
