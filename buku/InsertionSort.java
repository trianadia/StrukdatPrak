package buku;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {60, 40, 20, 80, 90, 10};

        for(int i = 1; i < data.length; i++){
            int temp = data[i];
            int j = i - 1;

            while(j >= 0 && data[j] > temp){
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }

        for(int x : data){
            System.out.print(x + " ");
        }
    }
}

