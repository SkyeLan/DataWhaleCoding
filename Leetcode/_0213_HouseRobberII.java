package DataWhale.Leetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed. All houses at this place are arranged in a circle. That means the first house is
 * the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without alerting the police.
 */
public class _0213_HouseRobberII {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] money = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0)
                money[i] = nums[i];
            else if (i == 1)
                money[i] = nums[0] > nums[1] ? nums[0] : nums[1];
            else
                money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        int max = money[nums.length - 2];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1)
                money[i] = nums[i];
            else if (i == 2)
                money[i] = nums[1] > nums[2] ? nums[1] : nums[2];
            else
                money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        return money[nums.length - 1] > max ? money[nums.length - 1] : max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
