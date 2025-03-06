#include<iostream>
using namespace std;

void MultipleOfTwo(int *arr,int n){
	for(int i=0; i<n; i++){
		arr[i]*=2;
		cout<<arr[i]<<" ";
	}

	cout<<endl;
}

int main(){
	int n;
	cout<<"Enter how many numbers you want: ";
	cin>>n;

	int arr[n];

	cout<<"Enter "<<n<<" numbers: ";
	for(int i=0; i<n; i++){
		cin>>arr[i];
	}

	cout<<"The numbers multiplied by 2 are: ";
	MultipleOfTwo(arr,n);
}
