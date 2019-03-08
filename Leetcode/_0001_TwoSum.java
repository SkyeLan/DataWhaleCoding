package DataWhale.Leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class _0001_TwoSum {
    // 用一个hashMap来记录，key记录target-numbers[i]的值，value记录
    // numbers[i]的i的值，如果碰到一个numbers[j]在hashMap中存在，那
    // 么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为
    // 答案
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null)
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
