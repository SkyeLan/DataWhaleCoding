package DataWhale.Leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 */
public class _0026_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > nums[index])
                nums[++index] = nums[i];
        return nums.length == 0 ? 0 : index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++)
            System.out.print(nums[i] + " ");
    }
}
