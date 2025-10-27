package p8;

class HashTable {
    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Table:");
        for (int j = 0; j < size; j++) {
            if (hashArray[j] != null) {
                System.out.println(" | " + j + "\t | " + hashArray[j].getKey() + " |");
            } else {
                System.out.println(" | " + j + "\t | -- |");
            }
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int data) {
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int count = 0; // batas langkah agar tidak infinite loop
        while (hashArray[hashVal] != null && count < size) {
            ++hashVal;
            hashVal %= size;
            count++;
        }
        if (count < size) {
            hashArray[hashVal] = item;
        } else {
            System.out.println("Tabel penuh! Tidak dapat menambahkan data: " + data);
        }
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        int count = 0;
        while (hashArray[hashVal] != null && count < size) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
            count++;
        }
        return null; // jika tidak ditemukan
    }
}