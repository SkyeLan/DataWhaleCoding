package DataWhale.Leetcode;

/**
 * Given an array nums and a value val, remove all instances of that
 * value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you
 * leave beyond the new length.
 */
public class _0027_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val)
                nums[left] = nums[right--];
            else
                left++;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }
}
