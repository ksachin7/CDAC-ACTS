#include<iostream>
using namespace std;

float avgOfNum(int *arr,int n){
	int sum=0;
	for(int i=0;i<n;i++){
		sum+=arr[i];
	}
	return float(sum)/n;
}

int main(){
	int n;

	cout<<"Enter how many Numbers you want: ";
	cin>>n;

	int arr[n];
	cout<<"Enter "<<n<<" Numbers";

	for(int i=0;i<n;i++){
		cin>>arr[i];
	}

	cout<<"The avg. of numbers is: "<<avgOfNum(arr,n)<<endl;
}
