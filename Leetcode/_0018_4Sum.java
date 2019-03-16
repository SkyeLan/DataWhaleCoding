package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the
 * array which gives the sum of target.
 * <p>
 * Note:
 * The solution set must not contain duplicate quadruplets.
 */
public class _0018_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 3; l++) {
            if (nums[0] > 0)
                break;
            if (l != 0 && nums[l] == nums[l - 1])
                continue;
            for (int i = l + 1; i < nums.length - 2; i++) {
                if (i != l + 1 && nums[i] == nums[i - 1])
                    continue;
                int j = i + 1, k = nums.length - 1;
                int target2 = target - nums[l] - nums[i];

                while (j < k) {

                    if (nums[j] + nums[k] == target2) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[i]);
                        list.add(nums[j++]);
                        list.add(nums[k--]);
                        lists.add(list);
                    } else if (nums[j] + nums[k] < target2)
                        j++;
                    else
                        k--;


                    while (j < k && j - 1 > i && nums[j] == nums[j - 1])
                        j++;
                    while (k > j && k + 1 < nums.length - 1 && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        int target = -7;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }
}
