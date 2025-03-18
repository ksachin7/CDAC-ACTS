#include<iostream>
using namespace std;

void RightAngleTrianglePattern(int n){

	for(int r=0; r<n; r++){
		for(int c=r+1; c<=n; c++){
			cout<<"*";
		}
		cout<<endl;
	}
}

void RightAngleTrianglePatternFlipped(int n){

	for(int r=0; r<n; r++){
		for(int c=0; c<r; c++){
			cout<<" ";
		}

		for(int c=r+1; c<=n; c++){
			cout<<"*";
		}
		cout<<endl;
	}
}

void EquilateralTrianglePattern(int n) {
    if (n <= 0) {
        cout << "Invalid input!" << endl;
        return;
    }

    int numStars = 1;
    int spaces = n - 1;

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < spaces; c++) {
            cout << " ";
        }

        for (int c = 0; c < numStars; c++) {
            cout << "*";
        }

        spaces--;
        numStars += 2;

        cout << endl;
    }
}


int main(){
	int n;

	cout<<"Enter size of the triangle: ";
	cin>>n;

	RightAngleTrianglePattern(n);
	cout<<endl;

	RightAngleTrianglePatternFlipped(n);
	cout<<endl;

	EquilateralTrianglePattern(n);
	cout<<endl;

	return 0;
}