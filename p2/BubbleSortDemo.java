
package p2;

class BubbleSortDemo {
    private int[] arr;
    private int nElemen;

    public BubbleSortDemo(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                    display();
                }
            }
        }
    }

    private void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static void main(String[] args) {
        BubbleSortDemo data = new BubbleSortDemo(10);
        data.insert(50);
        data.insert(30);
        data.insert(70);
        data.insert(20);
        data.insert(60);
        data.insert(40);

        System.out.println("Sebelum sorting:");
        data.display();

        data.bubbleSort();

        System.out.println("Sesudah sorting:");
        data.display();
    }
}








