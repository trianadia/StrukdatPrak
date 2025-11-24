package buku;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {60, 40, 20, 80, 90, 10};

        for(int i = 0; i < data.length - 1; i++){
            for(int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        for(int x : data){
            System.out.print(x + " ");
        }
    }
}

