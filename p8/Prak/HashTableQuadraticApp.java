package p8.Prak;


class Data {
    private int data;

    public Data(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }
}

class HashTable {
    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Isi tabel hash:");
        for (int j = 0; j < size; j++) {
            if (hashArray[j] != null) {
                System.out.println(j + " --> " + hashArray[j].getKey());
            } else {
                System.out.println(j + " --> (kosong)");
            }
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % size;
    }

    // Implementasi Quadratic Probing
    public void insert(int data) {
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int i = 1; // increment quadratic (i²)

        // selama posisi tidak kosong, lakukan quadratic probing
        while (hashArray[hashVal] != null) {
            hashVal = (hashFunc(key) + i * i) % size;
            i++;
            if (i > size) { // jika sudah memeriksa semua slot
                System.out.println("Tabel penuh, tidak bisa menambahkan data: " + data);
                return;
            }
        }
        hashArray[hashVal] = item;
    }
}

public class HashTableQuadraticApp {
    public static void main(String[] args) {
        HashTable table = new HashTable(15);

        // Data seperti soal nomor 1
        int[] dataAwal = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        for (int d : dataAwal) {
            table.insert(d);
        }

        System.out.println("=== Isi tabel SEBELUM penambahan data ===");
        table.displayTable(); 

        table.insert(55);
        table.insert(101);
        table.insert(7);
        table.insert(15);
        table.insert(567);

        System.out.println("=== Isi tabel SESUDAH penambahan data (Quadratic Probing) ===");
        table.displayTable(); 
    }
}
