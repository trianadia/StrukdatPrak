package Prak3;

class Stack {
    private char[] stackArray;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        if (top < maxSize - 1) {
            stackArray[++top] = c;
        }
    }

  
    public char pop() {
        return stackArray[top--];
    }

   
    public boolean isEmpty() {
        return (top == -1);
    }
}
