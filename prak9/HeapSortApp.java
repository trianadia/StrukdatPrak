package prak9;

import java.util.Random;

class Node {
    private int data;

    public Node(int key) {
        data = key;
    }

    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        data = id;
    }
}

class Heap {
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

    public void displayTree() {
        int n = maxSize;
        if (n == 0) {
            System.out.println("(empty)");
            return;
        }

        int levels = (int) (Math.floor(Math.log(n) / Math.log(2)) + 1);
        int unit = 3; // lebar dasar tiap node (untuk spasi)
        for (int level = 0; level < levels; level++) {
            int levelNodes = (int) Math.pow(2, level);
            int start = levelNodes - 1;
            int spacing = (int) (Math.pow(2, levels - level) * unit);

            StringBuilder line = new StringBuilder();
           
            for (int s = 0; s < spacing / 2; s++) line.append(' ');

            for (int i = 0; i < levelNodes; i++) {
                int idx = start + i;
                String val = "--";
                if (idx < n && heapArray[idx] != null) val = String.valueOf(heapArray[idx].getKey());
                
                line.append(String.format("%-2s", val));
                
                for (int s = 0; s < spacing; s++) line.append(' ');
            }
            System.out.println(line.toString().replaceFirst("\\s+$", ""));

            
            if (level < levels - 1) {
                StringBuilder links = new StringBuilder();
                for (int s = 0; s < spacing / 2 - 1; s++) links.append(' ');

                for (int i = 0; i < levelNodes; i++) {
                    int idx = start + i;
                    // untuk tiap parent cetak "/   \", cek apakah anak ada untuk menampilkan garis; jika tidak, cetak spasi
                    boolean leftExists = (2 * idx + 1) < n && heapArray[2 * idx + 1] != null;
                    boolean rightExists = (2 * idx + 2) < n && heapArray[2 * idx + 2] != null;

                    links.append(leftExists ? "/" : " ");
                    // jarak antara / dan \
                    for (int s = 0; s < 1; s++) links.append(' ');
                    links.append(rightExists ? "\\" : " ");

                    // spasi antar pasangan penghubung
                    for (int s = 0; s < spacing - 1; s++) links.append(' ');
                }
                System.out.println(links.toString().replaceFirst("\\s+$", ""));
            }
        }
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
       
        currentSize = maxSize;
        for (int j = maxSize / 2 - 1; j >= 0; j--)
            trickleDown(j);

        for (int j = maxSize - 1; j >= 0; j--) {
            Node biggest = heapArray[0];
            heapArray[0] = heapArray[j];
            heapArray[j] = biggest;
            currentSize--;
            trickleDown(0);
        }
    }
}

public class HeapSortApp {
    public static void main(String[] args) {
        int size = 10;
        Heap heap = new Heap(size);
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int randomValue = rand.nextInt(100); 
            heap.insertAt(i, randomValue);
            heap.incrementSize();
        }

        System.out.println("\n=== HEAP SEBELUM DIURUTKAN ===");
        heap.displayTree();

        heap.heapSort();

        System.out.println("\n=== HEAP SETELAH DIURUTKAN ===");
        heap.displayTree();
    }
}
