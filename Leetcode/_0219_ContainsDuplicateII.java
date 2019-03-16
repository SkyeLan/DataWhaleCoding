package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 */
public class _0219_ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            if (i - k >= 0)
                set.remove(nums[i - k]);
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
