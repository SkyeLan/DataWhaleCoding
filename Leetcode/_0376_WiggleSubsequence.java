package DataWhale.Leetcode;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly
 * alternate between positive and negative. The first difference (if one exists) may be either positive or
 * negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately
 * positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first
 * because its first two differences are positive and the second because its last difference is zero.
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original
 * sequence, leaving the remaining elements in their original order.
 */
public class _0376_WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};
        System.out.println(wiggleMaxLength(nums));
    }
}
