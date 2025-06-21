#include <iostream>
#include <string>
using namespace std;

bool isPrimeLoop(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0)
            return false;
    }
    return true;
}

bool isPrimeRecursive(int n, int i = 2) {
    if (n <= 1) return false;
    if (i * i > n) return true;
    if (n % i == 0) return false;
    return isPrimeRecursive(n, i + 1);
}

int factorialLoop(int n) {
    int result = 1;
    for (int i = 2; i <= n; ++i)
        result *= i;
    return result;
}

int factorialRecursive(int n) {
    if (n <= 1)
        return 1;
    return n * factorialRecursive(n - 1);
}

int fibonacciLoop(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int prev = 0, curr = 1;
    for (int i = 2; i <= n; ++i) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}

int fibonacciRecursive(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

bool isPalindromeLoop(const string& str) {
    int left = 0, right = str.length() - 1;
    while (left < right) {
        if (str[left] != str[right])
            return false;
        left++;
        right--;
    }
    return true;
}

bool isNumberPalindrome(int num) {
    int original = num, reversed = 0;
    while (num > 0) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
    }
    return original == reversed;
}

bool isPalindromeRecursive(const string& str, int left, int right) {
    if (left >= right) return true;
    if (str[left] != str[right]) return false;
    return isPalindromeRecursive(str, left + 1, right - 1);
}


void findSubString(string sub) {
    string text;
    cout << "Enter the main string: ";
    getline(cin, text);

    cout << "Enter the substring to search: ";
    getline(cin, sub);

    if (text.find(sub) != string::npos) {
        cout << "Substring found!" << endl;
    } else {
        cout << "Substring not found!" << endl;
    }
}

bool containsSubstring(const string& text, const string& sub) {
    int n = text.length(), m = sub.length();
    for (int i = 0; i <= n - m; ++i) {
        if (text.substr(i, m) == sub)
            return true;
    }
    return false;
}
