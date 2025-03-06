#include<iostream>
using namespace std;

void pattern1(int n){
	for(int i=n; i>0; i--){
                for(int j=1; j<=i; j++){
                        cout<<"*";
                }
                cout<<endl;
        }
	cout<<endl;
}

void pattern1Flipped(int n){
	for(int i=0; i<=n; i++){
                for(int j=i; j>0; j--){
                        cout<<"*";
                }
                cout<<endl;
        }
	cout<<endl;
	
}

void pattern2(int n){
	for(int r=n; r>0; r--){
		for(int c=r; c<n; c++){
			cout<<" ";
		}

		for(int c=n; c>(n-r); c--){
			cout<<"*";
		}
		cout<<endl;
	}
	cout<<endl;
}

void pattern2Flipped(int n){
	for(int r=n; r>=0; r--){
		for(int c=0; c<r; c++){
			cout<<" ";
		}

		for(int c=r; c<n; c++){
			cout<<"*";
		}
		cout<<endl;
	}
	cout<<endl;
}

void pattern3(int n){
	for(int r=n; r>0; r--){

		// top left
		for(int c=1; c<=r; c++){
                        cout<<"*";
                }

                for(int c=r; c<n; c++){
                        cout<<" ";
                }
 		
		// top-right
                for(int c=r; c<n; c++){
                        cout<<" ";
                }

                for(int c=n; c>n-r; c--){
                        cout<<"*";
                }
                cout<<endl;
        }
	
	for(int r=n; r>0; r--){

		// bottom left	
                for(int c=r; c<=n; c++){
                        cout<<"*";
                }
	 	for(int c=0; c<r-1; c++){
                        cout<<" ";
                }

		// bottom right
		for(int c=0; c<r-1; c++){
                       cout<<" ";
                 }

                for(int c=r; c<=n; c++){
                        cout<<"*";
                }

                        cout<<endl;
        }
	cout<<endl;
}

void pattern4(int n){
	for(int r=0; r<n; r++){

		// uppper triangle
		for(int c=n; c>r; c--){
			cout<<" ";
		}
		for(int c=1; c<2*r; c++){
			cout<<"*";	
		}
	 	cout<<endl;
	}
	
	// lower triangle
	for(int r=n; r>0; r--){
                for(int c=r; c<n; c++){
                        cout<<" ";
                }

                for(int c=n; c>(n-r); c--){
                        cout<<"*";
                }

                for(int c=n-1; c>(n-r); c--){
                        cout<<"*";
                }

		cout<<endl;
	}
	cout<<endl;
}

int main(){
	int n;
	cout<<"Enter Number: ";
	cin>>n;
	
	pattern1(n);
	pattern1Flipped(n);
	pattern2(n);
	pattern2Flipped(n);
	pattern3(n);
	pattern4(n);

	return 0;
}
