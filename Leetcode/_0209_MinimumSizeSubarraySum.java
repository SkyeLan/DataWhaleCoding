package DataWhale.Leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal
 * length of a contiguous subarray of which the sum ≥ s. If there isn't one,
 * return 0 instead.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which
 * the time complexity is O(n log n).
 */
public class _0209_MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
//        int minL = nums.length + 1;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i], l;
//            if (sum >= s) {
//                minL = 1;
//                break;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum >= s) {
//                    l = j - i + 1;
//                    if (l < minL)
//                        minL = l;
//                    break;
//                }
//            }
//        }
//        return minL == nums.length + 1 ? 0 : minL;
        if (nums.length == 0)
            return 0;
        int left = 0, right = 0, sum = nums[left];
        int minL = nums.length + 1;
        while (left <= right && right < nums.length) {
            if (sum >= s && right - left + 1 < minL)
                minL = right - left + 1;
            if (right + 1 < nums.length && sum < s)
                sum += nums[++right];
            else
                sum -= nums[left++];
        }
        return minL == nums.length + 1 ? 0 : minL;
    }

    public static void main(String[] args) {
        int s = 6;
        int[] nums = {10, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
    }
}
