#include <iostream>
using namespace std;

// Node structure
struct Node {
    int data;
    Node* next;
};

// Linked List class
class LinkedList {
private:
    Node* head;

public:
    // Constructor
    LinkedList() {
        head = nullptr;
    }

    // Insert at the end
    void insert(int value) {
        Node* newNode = new Node{value, nullptr};

        if (!head) {
            head = newNode;
            return;
        }

        Node* temp = head;
        while (temp->next)
            temp = temp->next;
        temp->next = newNode;
    }

    // Delete a node by value
    void remove(int value) {
        if (!head) return;

        if (head->data == value) {
            Node* toDelete = head;
            head = head->next;
            delete toDelete;
            return;
        }

        Node* temp = head;
        while (temp->next && temp->next->data != value)
            temp = temp->next;

        if (temp->next) {
            Node* toDelete = temp->next;
            temp->next = temp->next->next;
            delete toDelete;
        }
    }

    // Search for a value
    bool search(int value) {
        Node* temp = head;
        while (temp) {
            if (temp->data == value)
                return true;
            temp = temp->next;
        }
        return false;
    }

    // Print the list
    void display() {
        Node* temp = head;
        while (temp) {
            cout << temp->data << " -> ";
            temp = temp->next;
        }
        cout << "NULL" << endl;
    }

    // Destructor to free memory
    ~LinkedList() {
        while (head) {
            Node* temp = head;
            head = head->next;
            delete temp;
        }
    }
};

// Main function to test the LinkedList
int main() {
    LinkedList list;

    list.insert(10);
    list.insert(20);
    list.insert(30);

    cout << "List: ";
    list.display();

    cout << "Searching 20: " << (list.search(20) ? "Found" : "Not Found") << endl;

    list.remove(20);
    cout << "After deleting 20: ";
    list.display();

    return 0;
}
