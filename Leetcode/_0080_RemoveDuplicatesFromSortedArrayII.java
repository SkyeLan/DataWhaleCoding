package DataWhale.Leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 */
public class _0080_RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        boolean doubleTime = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[index] && !doubleTime) {
                doubleTime = true;
                nums[++index] = nums[i];
                continue;
            }
            if (nums[i] > nums[index]) {
                doubleTime = false;
                nums[++index] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++)
            System.out.print(nums[i] + " ");
    }
}
