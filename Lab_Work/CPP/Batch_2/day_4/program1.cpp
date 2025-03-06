#include<iostream>
using namespace std;

void sort(int *arr, int n){
	int tmp=0;
	for(int i=0; i<n; i++){
		for(int j=i+1; j<n; j++){
		if(arr[j] < arr[i]){
		 	tmp=arr[j];
			arr[j]=arr[i];
			arr[i]=tmp;	
		 }
		}
	}
}

void printArray(int *arr, int  n){
	sort(arr, n);
	for(int i=0; i<n; i++){
		cout<<arr[i]<<" ";
	}
	cout<<endl;
}

int main(){
	int n;
	cout<<"Enter size of the array: ";
	cin>> n;

	int array[n];
	cout<<"Enter" << n << " numbers: ";
	for(int i=0; i<n; i++){
		cin>>array[i];
	}

	printArray(array, n);
}
