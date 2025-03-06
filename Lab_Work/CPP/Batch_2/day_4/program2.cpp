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


void findMinMax(int *arr, int n){
	sort(arr, n);
	
	cout<<"min: "<<arr[0]<<" max: "<<arr[n-1]<<" second-min: "<<arr[1]<<" second-max:"<<arr[n-2];
}

int main(){
	int n;

	cout<<"Enter how many numbers you want to enter: "<<endl;
	cin>>n;

	int array[n];
	       
	cout<<"Enter numbers: "<<endl;
	for(int i=0; i<n; i++){
		cin>>array[i];
	}

	findMinMax(array, n);
	
	return 0;
}
