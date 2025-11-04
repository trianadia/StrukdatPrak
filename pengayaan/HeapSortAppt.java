package pengayaan;

import java.util.Random;

public class HeapSortAppt {
    public static void main(String[] args) {
        int size = 10;
        Heap heap = new Heap(size);
        Random rand = new Random();

        // Masukkan data acak
        for (int i = 0; i < size; i++) {
            int randomValue = rand.nextInt(100); // angka 0–99
            heap.insertAt(i, randomValue);
            heap.incrementSize();
        }

        System.out.println("=== ARRAY SEBELUM DIURUTKAN ===");
        heap.displayTree();

        heap.heapSort();

        System.out.println();
        // Cetak tampilan heap setelah perubahan key / setelah proses
        System.out.println("=== ARRAY SETELAH DIURUTKAN ===");
        heap.displayTree();
    }
}

