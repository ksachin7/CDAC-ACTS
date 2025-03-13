#include<iostream>
#include"header.h"

using namespace std;

MobilePhone::MobilePhone(){
	this->serialNo=0;
	this->modelNo="";
	this->brandName="";
	this->price=0;
}

void MobilePhone::Accept(int serialNo,string modelNo,string brandName,double price){
	cout<<"Enter Serial Number: ";
	this->serialNo=serialNo;
	cout<<"Enter Model Number: ";
	this->modelNo=modelNo;
	cout<<"Enter Brand Name: ";
	this->brandName=brandName;
	cout<<"Enter price : ";
	this->price=price;
}

void MobilePhone::Display(){
	cout<<"serialNo: "<<this->serialNo;

	cout<<"modelNo: "<<this->modelNo;

	cout<<"brandName: "<<this->brandName;

	cout<<"price: "<<this->price;

}

