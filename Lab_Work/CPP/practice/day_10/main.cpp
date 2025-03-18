#include<iostream>
#include<fstream>
#include<string>
#include"header.h"
using namespace std;

int main(){
	// MobilePhone OnePlus;
	char ch;

	cout<<"Please choose an option: \n";
	cout<<"1. Read File: \n";
	cout<<"2. Write to a File: \n";
	cout<<"3. Store in an Array, sort and Display File contents: \n";

	cin>>ch; 
	int n =1000;

	ifstream readFile;
	ofstream writeFile;
	
	// MobilePhone *arr = new MobilePhone(1234567, "G24", "Samsung", 74000);
	MobilePhone *arr = new MobilePhone[n];
	
	switch(ch){
		case '1':{
				readFile.open("File.txt");
				if (!readFile) {
	                cout << "Unable to open file for reading!" << endl;
	                return 1;
            	}
            	
            	// reading logic
            	string str;
            	// for(int i=0; i<n; i++){
            	// 	getline(readFile, str);
            	// 	cout<<str<<endl;
            	// }

            	while(readFile){
            		getline(readFile, str);		// Read a line from the file into the string variable 'str'
            		cout<<str<<endl;
            	}

            	readFile.close();
				break;
			}
		case '2':{
				if(!writeFile){
					cout<<"Unable to open file!";
					return 1;
				}
				writeFile.open("File.txt", ios::app);
				
				// cout<<"Enter data: ";
				// OnePlus.Accept(12438,"h32","OnePlus",40000);
				// OnePlus.Display();
				char choice;
				
				// do{
					for(int i=0; i<n; i++){
						cout << "Would you like to enter phone details? ('y' to continue, 'n' to exit): ";
						cin>>choice;
						
						// Clear input buffer before using getline
				        cin.ignore(numeric_limits<streamsize>::max(), '\n');

						if(choice == 'y' || choice == 'Y'){
							cout << "Enter details for MobilePhone " << i + 1 << ":\n";
							arr[i].Accept();
							writeFile<<arr[i]<<endl;
						}
						else if(choice == 'n' || choice == 'N'){
		                    break;
		                }
		                else{
		                    cout << "Invalid choice. Please enter 'y' or 'n'.\n";
		                }

					}
				// }
				// while(choice != 'n');
				
				// for(const MobilePhone& phone: arr){
				// 	phone.Display();
				// }

				for (int i = 0; i < n; i++) {
					cout<<arr[i].getSerialNo()<<endl;
					if(arr[i].getSerialNo()!=0)
	                	arr[i].Display();
	                break;
	            }

				writeFile.close();
				break;
			}
		case '3':{
			int noOfPhones = 0;  // number of phones in the array after loading from the file
		    MobilePhone* phoneArr = nullptr;  // Dynamically allocated array
			phoneArr = new MobilePhone[n];  
			
			noOfPhones= fileToArray("File.txt", phoneArr, n);
			// SortByPrice(phoneArr, noOfPhones);
			// for(MobilePhone phone: phoneArr){
			// 	phone.Display();
			// }

			// Display the sorted phones
		    for (int i = 0; i < noOfPhones; i++) {
		        phoneArr[i].Display();
		    }

		    delete[] phoneArr; 
		    break;
		}

		default: 
			cout<<"Invalid Option!"<<endl;
			break;
	}
	delete[] arr;

	return 0;
}
