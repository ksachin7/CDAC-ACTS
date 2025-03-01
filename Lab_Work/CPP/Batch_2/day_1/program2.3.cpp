#include<iostream>
#include <bitset>
#include <string>
#include <cmath>
using namespace std;


int binary_to_int(const string &binary){
	int result= 0;
	int power= 0;

	for(int i=binary.size(); i>=0; i--){
		if(binary[i] == '1')
			result+=pow(2, power);
	}
	power++;
	return result;
}

int main(){
	
	string binary1, binary2;

    cout << "Enter the first binary number: ";
    cin >> binary1;

    cout << "Enter the second binary number: ";
    cin >> binary2;
    
    int num1 = binary_to_int(binary1);
    int num2 = binary_to_int(binary2);
    
    int sum = num1 + num2;
    
    cout << "Binary 1: " << binary1 << endl;
    cout << "Binary 2: " << binary2 << endl;
    
    cout << "Sum: " << bitset<8>(sum) << endl;


	return 0;
}