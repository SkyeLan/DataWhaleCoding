package DataWhale.Leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so
 * that objects of the same color are adjacent, with the colors in the order red,
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
 * array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class _0075_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right)
            if (nums[index] == 0) {
                swap(nums, left, index);
                index++;
                left++;
            } else if (nums[index] == 2) {
                swap(nums, right, index);
                right--;
            } else
                index++;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 1};
        sortColors(a);
        for (int num : a)
            System.out.print(num + " ");
    }
}
