package DataWhale.Task2;

import java.util.Arrays;
import java.util.List;

/**
 * 实现数组全排列
 */
public class FullyArrange {
    public static void arrange(int[] arr, int start, int end) {
        if (start == end)
            System.out.println(Arrays.toString(arr));
        else
            for (int i = start; i <= end; i++) {
                // 交换数据
                swap(arr, start, i);
                arrange(arr, start + 1, end);
                swap(arr, i, start);
            }
    }

    public static void swap(int arr[], int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        arrange(a, 0, a.length - 1);
    }
}

