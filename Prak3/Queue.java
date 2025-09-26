
package Prak3;

class Queue {
    private int maxSize;
    private String[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    
    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Maaf " + item + ", antrian masih penuh");
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = item;
            nItems++;
            System.out.println(item + " masuk antrian");
        }
    }

    
    public String dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            String temp = queueArray[front];
            queueArray[front] = "Kosong"; 
            front = (front + 1) % maxSize;
            nItems--;
            return temp;
        }
    }

    
    public boolean isEmpty() {
        return (nItems == 0);
    }

    
    public boolean isFull() {
        return (nItems == maxSize);
    }

    
    public void displayQueue() {
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queueArray[i] + ",");
        }
        System.out.println();
    }
}
