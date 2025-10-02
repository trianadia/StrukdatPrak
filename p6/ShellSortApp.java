class ShellSortApp {
    private int[] arr;
    private int nElemen;

    public ShellSortApp(int max) {
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

    public void shellSort() {
        int in, out, temp;
        int h = nElemen / 2;   

        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;

                while (in > h - 1 && arr[in - h] >= temp) {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;

                display();
            }
            h /= 2;   // interval dibagi 2
        }
    }

    public static void main(String[] args) {
        ShellSortApp data = new ShellSortApp(8);

        data.insert(23);
        data.insert(12);
        data.insert(9);
        data.insert(30);
        data.insert(2);
        data.insert(50);
        data.insert(17);
        data.insert(42);

        System.out.println("Data sebelum sorting:");
        data.display();

        System.out.println("\nProses Shell Sort:");
        data.shellSort();

        System.out.println("\nData setelah sorting:");
        data.display();
    }
}
