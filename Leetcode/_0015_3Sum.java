package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array "nums" of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which
 * gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 */
public class _0015_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0)
                break;
            if (i - 1 >= 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];

            while (j < k) {

                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j++]);
                    list.add(nums[k--]);
                    results.add(list);
                } else if (nums[j] + nums[k] < target)
                    j++;
                else
                    k--;


                while (j < k && j - 1 > i && nums[j] == nums[j - 1])
                    j++;
                while (k > j && k + 1 < nums.length - 1 && nums[k] == nums[k + 1])
                    k--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(nums);
        for (List list : lists)
            System.out.println(list.toString());
    }
}
