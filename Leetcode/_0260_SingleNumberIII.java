package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 * <p>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class _0260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 0)
            return null;
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int num : nums)
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        int i = 0;
        for (int num : set)
            res[i++] = num;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] res = new _0260_SingleNumberIII().singleNumber(nums);
        for (int num : res)
            System.out.println(num + " ");
    }
}
