package DataWhale.Leetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers
 * such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to
 * the target, where index1 must be less than index2.
 * <p>
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the
 * same element twice.
 */
public class _0167_TwoSumII {
    // 双向指针，一头一尾 （因为数组是升序的），相向而行。如果两数之和加起来> target,
    // 说明right指针的数取得太大了， right--, 相反则left++, ==target 返回。
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target)
                j--;
            else if (numbers[i] + numbers[j] < target)
                i++;
            else
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int num[] = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(num, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
