package p8;

public class HashTableApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);

        // Tambahkan 10 item awal
        int[] dataAwal = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        for (int d : dataAwal) {
            table.insert(d);
        }

        System.out.println("=== Isi tabel sebelum penambahan ===");
        table.displayTable();

        // Tambahkan 5 item baru
        int[] dataTambahan = {5, 18, 25, 30, 99};
        for (int d : dataTambahan) {
            table.insert(d);
        }

        System.out.println("=== Isi tabel setelah penambahan ===");
        table.displayTable();

        // Pencarian data berdasarkan key
        int[] keyCari = {23, 100}; // 23 ada, 100 tidak ada
        for (int key : keyCari) {
            Data hasil = table.find(key);
            if (hasil != null) {
                System.out.println("Data dengan key " + key + " ditemukan di tabel.");
            } else {
                System.out.println("Data dengan key " + key + " tidak ditemukan di tabel.");
            }
        }
    }
}