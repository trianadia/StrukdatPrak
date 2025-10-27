package praktikum;

class Mahasiswa {
    private long nim;
    private String nama;
    

    public Mahasiswa(long nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public long getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void displayMhs() {
        System.out.print("\tNIM: " + nim);
        System.out.println(" Nama: " + nama);
    }
}

public class DataMahasiswa {
    private Mahasiswa[] arr;
    private int nElemen;

    public DataMahasiswa(int max) {
        arr = new Mahasiswa[max];
        nElemen = 0;
    }

    public void insert(long nim, String nama) {
        arr[nElemen] = new Mahasiswa(nim, nama);
        nElemen++;
    }

    public void displayArray() {
        for (int i = 0; i < nElemen; i++) {
            arr[i].displayMhs();
        }
        System.out.println();
    }

   
    // SHELL SORT (berdasarkan NIM)
    
    public void ShellSortByNim() {
        int h = nElemen / 2;
        while (h > 0) {
            for (int out = h; out < nElemen; out++) {
                Mahasiswa temp = arr[out];
                int in = out;
                while (in > h - 1 && arr[in - h].getNim() > temp.getNim()) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;
            }
            h /= 2;
        }
    }

    
    // MERGE SORT (berdasarkan NAMA)
   
    public void MergeSortByNama() {
        Mahasiswa[] workSpace = new Mahasiswa[nElemen];
        recMergeSort(workSpace, 0, nElemen - 1);
    }

    private void recMergeSort(Mahasiswa[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) return;
        else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(Mahasiswa[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int nItems = upperBound - lowerBound + 1;

        while (lowIndex <= mid && highIndex <= upperBound) {
            if (arr[lowIndex].getNama().compareToIgnoreCase(arr[highIndex].getNama()) < 0)
                workSpace[j++] = arr[lowIndex++];
            else
                workSpace[j++] = arr[highIndex++];
        }

        while (lowIndex <= mid)
            workSpace[j++] = arr[lowIndex++];
        while (highIndex <= upperBound)
            workSpace[j++] = arr[highIndex++];

        for (j = 0; j < nItems; j++)
            arr[lowerBound + j] = workSpace[j];
    }

   
    // QUICK SORT (berdasarkan NAMA)
    
    public void QuickSortByNama() {
        recQuickSort(0, nElemen - 1);
    }

    private void recQuickSort(int kiri, int kanan) {
        if (kanan - kiri <= 0)
            return;
        else {
            String pivot = arr[kanan].getNama();
            int partition = partitionIt(kiri, kanan, pivot);
            recQuickSort(kiri, partition - 1);
            recQuickSort(partition + 1, kanan);
        }
    }

    private int partitionIt(int kiri, int kanan, String pivot) {
        int leftPtr = kiri - 1;
        int rightPtr = kanan;
        while (true) {
            while (arr[++leftPtr].getNama().compareToIgnoreCase(pivot) < 0) ;
            while (rightPtr > 0 && arr[--rightPtr].getNama().compareToIgnoreCase(pivot) > 0) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, kanan);
        return leftPtr;
    }

    
    private void swap(int one, int two) {
        Mahasiswa temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

   
    public static void main(String[] args) {
        DataMahasiswa arr = new DataMahasiswa(10);

        arr.insert(16650200, "Jundi");
        arr.insert(16650210, "Ahmad");
        arr.insert(16650220, "Ismail");
        arr.insert(16650230, "Sofi");
        arr.insert(16650240, "Dinda");
        arr.insert(16650250, "Rais");
        arr.insert(16650260, "Helmi");
        arr.insert(16650270, "Agung");
        arr.insert(16650280, "Arina");

        System.out.println("=== DATA MAHASISWA SEBELUM SORTING ===");
        arr.displayArray();

        // MERGE SORT BY NAMA
        System.out.println("=== MERGE SORT (Berdasarkan Nama) ===");
        arr.MergeSortByNama();
        arr.displayArray();
        
        // SHELL SORT BY NIM
        System.out.println("=== SHELL SORT (Berdasarkan NIM) ===");
        arr.ShellSortByNim();
        arr.displayArray();

        // QUICK SORT BY NAMA
        System.out.println("=== QUICK SORT (Berdasarkan Nama) ===");
        arr.QuickSortByNama();
        arr.displayArray();
    }
}