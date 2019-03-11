package DataWhale.Task5;

public class HeapSort {
    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr) {
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        heapSort(a);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("\nheapSort: " + usedTime1 + " ns");
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
