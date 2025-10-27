package p8;

public class HashTableApp {
    public static void main(String[] args) {
        // ukuran tabel 15
        HashTable table = new HashTable(15);

        // tambahkan 10 item
        int[] items = {10, 25, 30, 45, 50, 65, 80, 95, 100, 115};
        for (int v : items) table.insert(v);

        // tampilkan isi tabel
        table.displayTable();
    }
}
