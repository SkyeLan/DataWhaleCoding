package DataWhale.Leetcode;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class _0349_IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int num1 : nums1)
            s1.add(num1);
        List<Integer> list = new ArrayList<>();
        for (int num2 : nums2)
            if (s1.contains(num2)) {
                list.add(num2);
                s1.remove(num2);
            }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
        for (int num : res)
            System.out.print(num + " ");
    }
}
