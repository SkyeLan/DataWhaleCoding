package DataWhale.Task3;

import java.util.Scanner;

public class binarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // ----------------------------------
            // int i = (left + right) / 2;
            int i = left + (right - left) / 2;
            // ----------------------------------
            if (arr[i] < target)
                left = i + 1;
            else if (arr[i] > target)
                right = i - 1;
            else
                return i;
        }
        return -1;
    }

    public static int binarySearchDiGui(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int i = left + (right - left) / 2;
            if (arr[i] < target)
                return binarySearchDiGui(arr, target, i + 1, right);
            else if (arr[i] > target)
                return binarySearchDiGui(arr, target, left, i - 1);
            else
                return i;
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

        System.out.println("非递归查找发现 " + n + " 在索引 " + binarySearch(a, n) + " 处");
        System.out.println("递归查找发现 " + n + " 在索引 " + binarySearchDiGui(a, n, 0, a.length - 1) + " 处");
    }
}
