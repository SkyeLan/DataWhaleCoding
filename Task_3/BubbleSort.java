package DataWhale.Task3;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        bubbleSort(a);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("bubbleSort: " + usedTime1 + " ns");
    }
}
