#include<iostream>
using namespace std;
template<class T>

class Array{
	
	private:
		int size;
		T *p;

	public:
		Array(){
			this->size=0;
			this->p=nullptr;
		}

		Array(int size){
			this->size=size;
			this->p= new T[size];
		}
		
		void Accept(int index,int value){
			for(int i=0;i<this->size;i++){
				p[index]=value;
			}
		}
		
		void Display(){
			cout<<"[ ";
			for(int i=0;i<this->size;i++){
				cout<<p[i]<<" ";
			}
			cout<<"]"<<endl;
		}
	
	// overloading [] operator
	T& operator [](int index){
		return p[index];
	}	
		
};

int main(){
	Array<int> arr(4);
	arr.Accept(0,1);
	arr.Accept(1,2);
	arr[2]=30;
	arr[3]= 100;
	arr.Display();

	Array<char> arr1(4);
	arr1[0]= 'a';
	arr1.Accept(1, 'b');
	arr1.Accept(2, 'c');
	arr1.Accept(3, 'd');
	arr1.Display();

return 0;
}
