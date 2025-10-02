public class QuickSortApp {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pi = partition(arr, left, right);
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {23, 12, 9, 30, 2, 50, 17, 42};

        System.out.println("Data sebelum sorting:");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Data setelah sorting:");
        for (int x : arr) System.out.print(x + " ");
    }
}
