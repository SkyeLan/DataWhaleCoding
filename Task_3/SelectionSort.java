package DataWhale.Task3;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 寻找最小的那个值的位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        selectionSort(a);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("selectionSort: " + usedTime1 + " ns");
    }
}