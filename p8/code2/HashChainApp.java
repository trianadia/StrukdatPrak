package p8.code2;

public class HashChainApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        // Tambahkan 10 item awal seperti pada soal nomor 1
        int[] dataAwal = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        for (int d : dataAwal) {
            table.insert(d);
        }

        System.out.println("=== Isi tabel hash chaining (10 item) ===");
        table.displayTable();

        // Tambahkan 5 item baru
        int[] dataTambahan = {5, 18, 25, 30, 99};
        for (int d : dataTambahan) {
            table.insert(d);
        }

        System.out.println("\n=== Isi tabel hash chaining setelah penambahan 15 item ===");
        table.displayTable();
    }
}
