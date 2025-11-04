package prak9.pengayaan;

public class Heapt {
    private Nodet[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heapt(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Nodet[size];
    }

    public void insertAt(int index, int value) {
        heapArray[index] = new Nodet(value);
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

    // ==============================
    // Perubahan utama ada di sini 👇
    // ==============================
    public void trickleDown(int index) {
        int smallerChild;
        Nodet top = heapArray[index];

        while (index < currentSize / 2) { // selama index punya anak
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            // pilih anak yang lebih kecil
            if (rightChild < currentSize &&
                    heapArray[leftChild].getKey() > heapArray[rightChild].getKey()) {
                smallerChild = rightChild;
            } else {
                smallerChild = leftChild;
            }

            // jika parent sudah lebih kecil dari anak terkecil → selesai
            if (top.getKey() <= heapArray[smallerChild].getKey())
                break;

            // tukar parent dengan anak yang lebih kecil
            heapArray[index] = heapArray[smallerChild];
            index = smallerChild;
        }

        heapArray[index] = top;
    }

    public void heapSort() {
        // membentuk MIN heap
        currentSize = maxSize;
        for (int j = maxSize / 2 - 1; j >= 0; j--)
            trickleDown(j);

        // menghapus satu per satu node dan simpan di akhir array
        for (int j = maxSize - 1; j >= 0; j--) {
            Nodet smallest = heapArray[0];
            heapArray[0] = heapArray[j];
            heapArray[j] = smallest;
            currentSize--;
            trickleDown(0);
        }
    }
}

