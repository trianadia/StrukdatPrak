package p8;

public class HashTableApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);

        // Data awal (10 item)
        int[] dataAwal = {10, 22, 31, 4, 15, 28, 17, 88, 59, 40};
        for (int data : dataAwal) {
            table.insert(data);
        }

        System.out.println("=== Isi Tabel Sebelum Penambahan (10 item) ===");
        table.displayTable();

        // Tambahkan 5 item baru
        int[] dataTambahan = {33, 19, 44, 56, 25};
        for (int data : dataTambahan) {
            table.insert(data);
        }

        System.out.println("=== Isi Tabel Setelah Penambahan (15 item) ===");
        table.displayTable();
    }
}

