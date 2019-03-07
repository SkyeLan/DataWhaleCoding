package DataWhale.Task3;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {15, 17, 22, 31, 48, 59, 68, 456};
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.print("请输入要查找的数: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println();

        System.out.println(n + " 在索引 " + binarySearch(a, n) + " 处");
    }
}
