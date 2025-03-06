#include<iostream>
#include<algorithm>
using namespace std;

void sortArray(int array[], int n){
	sort(array, array+n);
	for(int i=0; i<n; i++){
		cout<<array[i]<<" ";
	}
}

int main(){
	int n;
	int array[n];

	cout<<"Enter how many no. you want to enter: "<<endl;
	cin>>n;

	cout<<"Enter"<<n<<" numbers:";
	for(int i=0; i<n; i++){
		cin>>array[i];
	}

	sortArray(array, n);

	return 0;
}
