package DataWhale.Leetcode;

/**
 * Given an unsorted integer array,
 * find the smallest missing positive integer.
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class _0041_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            // 看正数nums[i]在不在index范围内，如果在，交换nums[i]和nums[nums[i]-1]
            // 注意，要判断是否相等，不然会死循环
            while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 一个一个往后看，第一个存的不是i+1的位置，就是缺的值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0};
        System.out.println(_0041_FirstMissingPositive.firstMissingPositive(arr));
    }

    public static void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}
