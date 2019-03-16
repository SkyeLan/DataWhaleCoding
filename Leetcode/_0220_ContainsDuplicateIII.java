package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the absolute difference between nums[i] and nums[j] is at
 * most t and the absolute difference between i and j is at most k.
 */
public class _0220_ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> son = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!son.isEmpty())
                return true;
            if (i - k >= 0)
                set.remove((long) nums[i - k]);
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3, t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
