package DataWhale.Task3;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    // 对arr[left ... right]部分进行partition操作
    // 返回p，使得 arr[left ... p-1] < arr[p]，arr[p+1 ... right] > arr[p]
    public static int partition(int arr[], int left, int right) {
        int j = left, l = left;
        // arr[l+1 ... j] < v，arr[j+1 ... i) > v
        for (int i = l + 1; i <= right; i++) {
            if (arr[i] < arr[l]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 73, 8, 13, 54, 46, 5, 156, 2};
        long startTime1 = System.nanoTime();
        quickSort(a, 0, a.length - 1);
        long endTime1 = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        long usedTime1 = (endTime1 - startTime1);
        System.out.println("quickSort: " + usedTime1 + " ns");
    }
}
