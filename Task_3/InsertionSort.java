package DataWhale.Task3;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++)
            // 寻找合适的插入位置
            for (int j = i; j > 0; j--)
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else
                    break;
    }

    public static void insertionSortUp(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
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
                arr[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {5, 1, 4, 3, 13, 54, 46, 5, 156, 2};
        int[] a2 = {5, 1, 4, 3, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        insertionSort(a1);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("insertionSort: " + usedTime1 + " ns");
        long startTime2 = System.nanoTime();
        insertionSortUp(a2);
        long endTime2 = System.nanoTime();
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        long usedTime2 = (endTime2 - startTime2);
        System.out.println("insertionSortUp: " + usedTime2 + " ns");

    }
}
