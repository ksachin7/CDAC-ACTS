#include<iostream>
#include<fstream>
#include<string>
#include"header.h"
using namespace std;

int main(){
	MobilePhone OnePlus;
	char ch;
	string data;
	cout<<"Choose Option: \n";
	cout<<"1.Read File: \n";
	cout<<"2.Write in a File: \n";

	cin>>ch; 
	int n =10;

	ifstream readFile;
	ofstream writeFile;
	
	// MobilePhone *arr = new MobilePhone(1234567, "G24", "Samsung", 74000);
	MobilePhone *arr = nullptr;
	
	switch(ch){
		case '1':{
			cout<<"Write File name you want to read: ";
				break;
			}
		case '2':{
			if(!writeFile){
				cout<<"Unable to open file: ";
				return 1;
			}
				// cout<<"Write file name you want to write: ";
				writeFile.open("Data.txt");
				
				cout<<"Enter data: ";
				// cin>>data;
			//	for(int i=0; i<){
			//	}
			//	G24.Accept();
				OnePlus.Accept(12438,"h32","OnePlus",40000);
				OnePlus.Display();
				writeFile<<OnePlus;

				writeFile.close();
				break;
		          
			}
			
		  }

	return 0;
}
