package DataWhale.Task3;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr.length - 1 - i; j++)
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        bubbleSort(a);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("bubbleSort: " + usedTime1 + " ns");
    }
}
