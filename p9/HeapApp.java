package p9;

public class HeapApp {
    public static void main(String[] args) {
        Heap heap = new Heap(35);

        int[] items = {70, 40, 50, 20, 60, 100, 80, 30, 10, 90, 110, 120};
        for (int item : items) {
            heap.insert(item);
        }

        System.out.println("=== HEAP AWAL ===");
        heap.displayHeap();

        // Tambah item baru
        int newItem = 115;
        System.out.println("\nMenambahkan item baru: " + newItem);
        heap.insert(newItem);

        System.out.println("\n=== HEAP SETELAH PENAMBAHAN ===");
        heap.displayHeap();

        // Hapus root
        System.out.println("\n=== HEAP SEBELUM PENGHAPUSAN ROOT ===");
        heap.displayHeap();

        Node removed = heap.remove();
        System.out.println("\nItem yang dihapus (root): " + removed.getKey());

        System.out.println("\n=== HEAP SETELAH PENGHAPUSAN ROOT ===");
        heap.displayHeap();

        // Ubah key
        int indexToChange = 3;
        int newValue = 95;
        System.out.println("\nMengubah key pada indeks " + indexToChange + " menjadi " + newValue);

        System.out.println("\n=== HEAP SEBELUM PERUBAHAN KEY ===");
        heap.displayHeap();

        heap.change(indexToChange, newValue);

        System.out.println("\n=== HEAP SETELAH PERUBAHAN KEY ===");
        heap.displayHeap();
    }
}
