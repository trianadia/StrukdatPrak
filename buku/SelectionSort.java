package buku;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {60, 40, 20, 80, 90, 10};

        for(int i = 0; i < data.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < data.length; j++){
                if(data[j] < data[minIndex]){
                    minIndex = j;
                }
            }

            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }

        for(int x : data){
            System.out.print(x + " ");
        }
    }
}

