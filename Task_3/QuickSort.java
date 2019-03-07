package DataWhale.Task3;

public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && arr[i] < arr[left])
                i++;
            while (j >= left + 1 && arr[j] > arr[left])
                j--;
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, left);
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        quickSort(a, 0, a.length - 1);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("\nquickSort: " + usedTime1 + " ns");
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
