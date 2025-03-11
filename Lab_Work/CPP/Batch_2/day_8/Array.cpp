#include <iostream>
using namespace std;

class Array {
private:
    int *arr;
    int size;

public:
    Array(int s) {
        size = s;
        arr = new int[size];
    }

    ~Array() {
        delete[] arr;
    }

    void accept() {
        cout << "Enter " << size << " elements: ";
        for (int i = 0; i < size; ++i) {
            cin >> arr[i];
        }
    }

    void display() {
        cout << "Array elements: ";
        for (int i = 0; i < size; ++i) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    Array arr(5);
    arr.accept();
    arr.display();
    return 0;
}
