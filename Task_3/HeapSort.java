package DataWhale.Task3;

public class HeapSort {

    public static void heapSort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++)
            maxHeap.insert(arr[i]);

        // 输出从小到大的顺序
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    public static void heapSort2(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        // 输出从小到大的顺序
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 6, 8, 1, 4, 5, 7};
        int[] a2 = {2, 3, 6, 8, 1, 4, 5, 7};
        long startTime1 = System.nanoTime();
        heapSort(a1);
        long endTime1 = System.nanoTime();
        long usedTime1 = (endTime1 - startTime1);
        long startTime2 = System.nanoTime();
        heapSort2(a2);
        long endTime2 = System.nanoTime();
        long usedTime2 = (endTime2 - startTime2);
        System.out.println("heapSort: " + usedTime1 + " ns");
        System.out.println("heapSort2: " + usedTime2 + " ns");
        for (int i = 0; i < a2.length; i++)
            System.out.print(a2[i] + " ");
    }
}
