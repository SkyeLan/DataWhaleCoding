package DataWhale.Task7;

public class ni_xu_dui {
    public static int NUM = 0;

    public static void qiujie(int[] arr, int left, int right) {
        // 使用归并排序
        if (left < right) {
            int mid = (right + left) / 2;
            qiujie(arr, left, mid);
            qiujie(arr, mid + 1, right);
            guibing(arr, left, mid, right);
        }
    }

    public static void guibing(int[] arr, int left, int mid, int right) {
        int l = left, i = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (l <= mid && i <= right)
            if (arr[l] < arr[i])
                temp[k++] = arr[l++];
            else {
                for (int j = l; j <= mid; j++) {
                    System.out.println(arr[j] + " " + arr[i]);
                }
                NUM += mid - l + 1;
                temp[k++] = arr[i++];
            }
        while (l <= mid)
            temp[k++] = arr[l++];
        while (i <= right)
            temp[k++] = arr[i++];
        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 8, 1, 4, 5, 7};
        qiujie(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(NUM);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
