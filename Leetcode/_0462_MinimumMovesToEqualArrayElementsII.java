package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements
 * equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 */
public class _0462_MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid;
        if (nums.length % 2 == 0) {
            mid = (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            mid = nums[nums.length / 2];
        }
        int count = 0;
        for (int num : nums)
            count += Math.abs(num - mid);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new _0462_MinimumMovesToEqualArrayElementsII().minMoves2(nums));
    }
}
