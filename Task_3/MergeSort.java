package DataWhale.Task3;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            if (arr[mid] > arr[mid + 1])
                merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right)
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (int l = 0; l < temp.length; l++)
            arr[left + l] = temp[l];
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        mergeSort(a, 0, a.length - 1);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("\nmergeSort: " + usedTime1 + " ns");
    }
}
