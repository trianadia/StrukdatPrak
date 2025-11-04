package prak9;

import java.util.Random;

public class HeapSortApp {
    public static void main(String[] args) {
        int size = 10;
        Heap heap = new Heap(size);
        Random rand = new Random();

        // Menambahkan elemen acak
        for (int i = 0; i < size; i++) {
            int randomValue = rand.nextInt(100); // angka 0–99
            heap.insertAt(i, randomValue);
            heap.incrementSize();
        }

        System.out.println("=== ARRAY SEBELUM DIURUTKAN ===");
        heap.displayArray();

        heap.heapSort();

        System.out.println("\n=== ARRAY SETELAH DIURUTKAN ===");
        heap.displayArray();
    }
}
