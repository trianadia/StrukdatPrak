package prak9;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public void insertAt(int index, int value) {
        heapArray[index] = new Node(value);
    }

    public void incrementSize() {
        currentSize++;
    }

    public void displayArray() {
        for (int j = 0; j < maxSize; j++) {
            if (heapArray[j] != null)
                System.out.print(heapArray[j].getKey() + " ");
            else
                System.out.print("-- ");
        }
        System.out.println();
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize &&
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void heapSort() {
        // membentuk heap
        currentSize = maxSize;
        for (int j = maxSize / 2 - 1; j >= 0; j--)
            trickleDown(j);

        // menghapus satu per satu node dan simpan di akhir array
        for (int j = maxSize - 1; j >= 0; j--) {
            Node biggest = heapArray[0];
            heapArray[0] = heapArray[j];
            heapArray[j] = biggest;
            currentSize--;
            trickleDown(0);
        }
    }
}

