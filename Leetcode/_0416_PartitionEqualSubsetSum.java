package DataWhale.Leetcode;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into
 * two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 */
public class _0416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int capacity = sum / 2;
        // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
        int[][] dp = new int[nums.length][capacity + 1];
        //遍历n个数字，即视为n个产品
        for (int i = 1; i < nums.length; i++)
            //加入了这种物品后更新状态
            for (int j = nums[i]; j <= capacity; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
        //放满了才能表示正好1/2
        return dp[nums.length - 1][capacity] == capacity;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new _0416_PartitionEqualSubsetSum().canPartition(nums));
    }
}
