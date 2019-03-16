package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, find three integers in
 * nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 */
public class _0016_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mostClost = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                mostClost = Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(mostClost - target) ? nums[i] + nums[left] + nums[right] : mostClost;
                if (nums[i] + nums[left] + nums[right] < target)
                    left++;
                else
                    right--;
            }
        }
        return mostClost;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, -1, -1, 3};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }
}
