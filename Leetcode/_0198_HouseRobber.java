package DataWhale.Leetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
 * have security system connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without alerting the police.
 */
public class _0198_HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] money = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                money[i] = nums[i];
            else if (i == 1)
                money[i] = nums[0] > nums[1] ? nums[0] : nums[1];
            else
                money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        return money[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
