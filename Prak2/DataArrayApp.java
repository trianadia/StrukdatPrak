
package Prak2;

public class DataArrayApp {
    public static void main(String[] args) {
        DataArray arr = new DataArray(10);
        arr.insert(16650200, "Jundi", "Malang");
        arr.insert(16650210, "Ahmad", "Sidoarjo");
        arr.insert(16650220, "Ismail", "Banyuwangi");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650240, "Dinda", "Bandung");
        arr.insert(16650250, "Rais", "Ambon");
        arr.insert(16650260, "Helmi", "Madura");
        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650280, "Arina", "Malang");
        
        System.out.println("Data Mahasiwa Sebelum Diurutkan: ");
        arr.displayArray();
        System.out.println("Sorting berdasarkan NIM, Bubble Sort: ");
        arr.BubbleSort();
        arr.displayArray();
        System.out.println("Sorting Berdasarkan NIM, selection Sort: ");
        arr.SelectionSort();
        arr.displayArray();
        System.out.println("Sorting Berdasarkan Nama, Insertion Sort: ");
        arr.InsertionbyName();
        arr.displayArray();
    }
}