package net.learning.computerscience.datastructures.stack;

public class Stack {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[size];
        this.top = -1;
    }

    public void push(long j) {
        if (isFull()) {
            System.out.println("Stack is already full.");
            return;
        }
        top++;
        stackArray[top] = j;
    }

    public long pop() {
        if (isEmpty()) {
            System.out.println("Stack is already empty.");
            return -1;
        }
        int oldTop = top;
        top--;
        return stackArray[oldTop];
    }

    public long peak() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

}
