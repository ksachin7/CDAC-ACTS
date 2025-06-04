package com.cdac.acts;

public interface Stack<T> {
    // Push an item onto the stack
    void push(T item);
    
    // Pop an item from the stack
    T pop();
    
    // Peek at the top item without removing it
    T peek();
    
    // Check if the stack is empty
    boolean isEmpty();
    
    // Return the number of elements in the stack
    int size();
}
