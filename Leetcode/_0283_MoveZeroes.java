package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array nums, write a function to move all 0's to the end of
 * it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class _0283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            while ( i < nums.length && nums[i] == 0)
                i++;
            if (i == nums.length)
                break;
            nums[j++] = nums[i++];
        }
        while (j < nums.length)
            nums[j++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
