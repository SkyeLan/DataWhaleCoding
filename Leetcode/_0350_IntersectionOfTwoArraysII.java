package DataWhale.Leetcode;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that
 * you cannot load all elements into the memory at once?
 */
public class _0350_IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1)
            if (map.containsKey(num1))
                map.put(num1, map.get(num1) + 1);
            else
                map.put(num1, 1);
        List<Integer> list = new ArrayList<>();
        for (int num2 : nums2)
            if (map.containsKey(num2) && map.get(num2) != 0) {
                list.add(num2);
                map.put(num2, map.get(num2) - 1);
            }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersect(nums1, nums2);
        for (int num : res)
            System.out.print(num + " ");
    }
}
