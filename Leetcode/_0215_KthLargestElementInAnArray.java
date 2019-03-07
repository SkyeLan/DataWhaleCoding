package DataWhale.Leetcode;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _0215_KthLargestElementInAnArray {
    // 快排
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private static int quickSort(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int p = partion(nums, left, right);
            if (p == nums.length - k)
                return nums[p];
            else if (p > nums.length - k)
                return quickSort(nums, left, p - 1, k);
            else
                return quickSort(nums, p + 1, right, k);
        }
        return -1;
    }

    private static int partion(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && nums[i] < nums[left])
                i++;
            while (j >= left + 1 && nums[j] > nums[left])
                j--;
            if (i > j)
                break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;
        return j;
    }


    public static void main(String[] args) {
        int num[] = {5, 2, 4, 1, 3, 6, 0};
        int k = 4;
        System.out.println(findKthLargest(num, k));
    }
}
