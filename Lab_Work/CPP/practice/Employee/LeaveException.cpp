#include<iostream>
#include<string>
#include<stdexcept>
using namespace std;

class LeaveException: public exception{

private:
	string message;

public:
    LeaveException(const string& msg) : message(msg) {}

    string& what() {
        return message;
    }

    ~LeaveException() throw() {}
};
