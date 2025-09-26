package p2;

class SelectionSortDemo {
    private int[] arr;
    private int nElemen;

    public SelectionSortDemo(int max) {
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

    public void insertionSort() {
        int i, curIn;
        for (curIn = 1; curIn < nElemen; curIn++) {
            int temp = arr[curIn];
            i = curIn;

            while (i > 0 && arr[i - 1] >= temp) {
                arr[i] = arr[i - 1];
                System.out.print("Setelah pergeseran: ");
                display();
                i--;
            }

            arr[i] = temp;
            System.out.print("Setelah penyisipan: ");
            display();
        }
    }

    public static void main(String[] args) {
        SelectionSortDemo data = new SelectionSortDemo(10);
        data.insert(50);
        data.insert(30);
        data.insert(70);
        data.insert(20);
        data.insert(60);
        data.insert(40);

        System.out.println("Sebelum sorting:");
        data.display();

        data.insertionSort();

        System.out.println("Sesudah sorting:");
        data.display();
    }
}
