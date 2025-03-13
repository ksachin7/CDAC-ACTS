#include<iostream>
#include<string>
using namespace std;

class MobilePhone{
	private:
                int serialNo; 
                string modelNo;
                string brandName;
                double price;

	public:
		MobilePhone();
		void Accept(int serialNo,string modelNo,string brandName,double price);
		void Display();
	
};
