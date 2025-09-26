
package Prak2;

class DataArray {
    private Mahasiswa[] arr;
    private int nElemen;

    public DataArray(int max) {
        arr = new Mahasiswa[max];
        nElemen = 0;
    }

    public void insert(long nim, String nama, String asal) {
        arr[nElemen] = new Mahasiswa(nim, nama, asal);
        nElemen++;
    }

    public void displayArray() {
        for (int i = 0; i < nElemen; i++) {
            arr[i].displayMhs();
        }
        System.out.println();
    }

    public void BubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i].getNim() > arr[i + 1].getNim()) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void SelectionSort() {
        int awal, i, min;
        for (awal = 0; awal < nElemen - 1; awal++) {
            min = awal;
            for (i = awal + 1; i < nElemen; i++) {
                if (arr[i].getNim() < arr[min].getNim()) {
                    min = i;
                }
            }
            swap(awal, min);
        }
    }

    public void InsertionbyName() {
        for (int i = 1; i < nElemen; i++) {
            Mahasiswa temp = arr[i];
            int j = i;
            // diperbaiki: hapus kurung ganda
            while (j > 0 && arr[j - 1].getNama().compareTo(temp.getNama()) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void swap(int one, int two) {
        Mahasiswa temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}


