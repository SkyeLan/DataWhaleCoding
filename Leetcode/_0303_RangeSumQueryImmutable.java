package DataWhale.Leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class _0303_RangeSumQueryImmutable {
    static class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int k = 0; k < nums.length; k++)
                sum[k + 1] = sum[k] + nums[k];
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int i = 0, j = 2;
        System.out.println(obj.sumRange(i, j));
    }
}
