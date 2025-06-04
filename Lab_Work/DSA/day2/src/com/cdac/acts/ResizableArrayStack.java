package com.cdac.acts;

public class ResizableArrayStack<T> implements Stack<T> {
    private T[] stack;       // Array to store stack elements
    private int size;        // Number of elements in the stack
    private int capacity;    // Capacity of the stack

    // Constructor with initial capacity
    public ResizableArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0.");
        }
        this.capacity = initialCapacity;
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Default constructor with initial capacity of 2
    public ResizableArrayStack() {
        this(2);  // Default capacity
    }

    // Resize the array when needed (doubling or halving the size)
    private void resize(int newCapacity) {
        T[] newStack = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
        capacity = newCapacity;
    }

    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null onto the stack.");
        }

        if (size == capacity) {
            resize(capacity * 2);  // Double the capacity when full
        }

        stack[size++] = item;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Pop from an empty stack.");
        }

        T item = stack[--size];
        stack[size] = null;  // Avoid loitering

        // Shrink the stack if it's too empty
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }

        return item;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Peek from an empty stack.");
        }

        return stack[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // String representation of the stack for debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        Stack<Integer> stack = new ResizableArrayStack<>();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushes: " + stack);

        // Peeking the top element
        System.out.println("Top item: " + stack.peek());

        // Popping an element
        System.out.println("Popped item: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Pushing another element
        stack.push(4);
        System.out.println("Stack after pushing 4: " + stack);

        // Size and isEmpty checks
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Test pop and peek from an empty stack (will throw an exception)
        try {
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
