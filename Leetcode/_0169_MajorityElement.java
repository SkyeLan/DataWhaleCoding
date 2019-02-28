package DataWhale.Leetcode;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more
 * than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the
 * majority element always exist in the array.
 */
public class _0169_MajorityElement {
    /**
     * 设一个当前遍历最多的元素value,一个遍历计数count
     * 遍历到相同的count就加一，不同count就减一
     * 因为总存在众数，所以不用考虑其他条件
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                value = nums[i];
            if (value == nums[i])
                count++;
            else
                count--;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3};
        System.out.println(_0169_MajorityElement.majorityElement(arr));
    }
}
