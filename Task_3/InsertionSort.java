package DataWhale.Task3;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--)
                if (arr[j - 1] > temp)
                    arr[j] = arr[j - 1];
                else {
                    arr[j] = temp;
                    break;
                }
            if (j == 0)
                arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {5, 1, 4, 3, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        insertionSort(a1);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a1.length; i++)
            System.out.print(a1[i] + " ");
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("\ninsertionSort: " + usedTime1 + " ns");
    }
}
