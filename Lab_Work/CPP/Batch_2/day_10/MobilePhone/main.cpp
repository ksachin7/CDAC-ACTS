#include <iostream>
#include <fstream>
#include <string>
#include "header.h"
using namespace std;

int main()
{
	// MobilePhone OnePlus;
	char ch;
	int n = 1000;

	ifstream readFile;
	ofstream writeFile;

	// MobilePhone *arr = new MobilePhone(1234567, "G24", "Samsung", 74000);
	MobilePhone *arr = new MobilePhone[n];

	while (true)
	{
		cout << "\nPlease choose an option: \n";
		cout << "1. Read File: \n";
		cout << "2. Write to a File: \n";
		cout << "3. Store in an Array, sort and Display File contents: \n";
		cout << "4. Exit: \n";

		cin >> ch;

		if (ch == '4')
		{
			// Exit the loop if the user chooses to exit
			cout << "Exiting program..." << endl;
			break;
		}

		switch (ch)
		{
		case '1':
		{
			readFile.open("File.dat", ios::binary);
			if (!readFile)
			{
				cout << "Unable to open file for reading!" << endl;
				return 1;
			}

			// reading logic
			// string str;
			int i = 0;

			cout << "+----------------------------------------------------------------+" << endl;
			while (readFile.read((char *)&arr[i], sizeof(MobilePhone)))
			{
				arr[i].Display();
				i++;
			}
			cout << "+----------------------------------------------------------------+" << endl;

			readFile.close();
			break;
		}
		case '2':
		{
			writeFile.open("File.dat", ios::binary | ios::app); // Open the file for binary writing (append mode)
			if (!writeFile)
			{
				cout << "Unable to open file for writing!";
				return 1;
			}

			// cout<<"Enter data: ";
			// OnePlus.Accept(12438,"h32","OnePlus",40000);
			// OnePlus.Display();
			char choice;

			for (int i = 0; i < n; i++)
			{
				cout << "Would you like to enter phone details? ('y' to continue, 'n' to exit): ";
				cin >> choice;

				// Clear input buffer before using getline
				cin.ignore(numeric_limits<streamsize>::max(), '\n');

				if (choice == 'y' || choice == 'Y')
				{
					cout << "Enter details for MobilePhone " << i + 1 << ":\n";
					arr[i].Accept();

					// Write the MobilePhone object to the file in binary format
					writeFile.write((char *)&arr[i], sizeof(MobilePhone));
				}
				else if (choice == 'n' || choice == 'N')
				{
					break;
				}
				else
				{
					cout << "Invalid choice. Please enter 'y' or 'n'.\n";
				}
			}

			// for(const MobilePhone& phone: arr){
			// 	phone.Display();
			// }

			for (int i = 0; i < n; i++)
			{
				// cout<<arr[i].getSerialNo()<<endl;
				if (arr[i].getSerialNo() != 0)
					arr[i].Display();
				break;
			}

			writeFile.close();
			break;
		}
		case '3':
		{
			int noOfPhones = 0; // number of phones in the array after loading from the file
			MobilePhone *phoneArr = new MobilePhone[n];
			; // Dynamically allocated array

			noOfPhones = fileToArray("File.dat", phoneArr, n);
			SortByPrice(phoneArr, noOfPhones);

			// for(MobilePhone phone: phoneArr){
			// 	phone.Display();
			// }

			cout << "+----------------------------------------------------------------+" << endl;
			// Display the sorted phones
			for (int i = 0; i < noOfPhones; i++)
			{
				phoneArr[i].Display();
			}
			cout << "+----------------------------------------------------------------+" << endl;

			delete[] phoneArr;
			break;
		}
		case '4':
		{
			cout << "Exiting program..." << endl;

			delete[] arr;
			return 0;
		}
		default:
			cout << "Invalid Option!" << endl;
			break;
		}
	}
	delete[] arr;

	return 0;
}
