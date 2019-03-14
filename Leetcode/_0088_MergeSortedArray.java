package DataWhale.Leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 */
public class _0088_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++)
            temp[i] = nums1[i];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n)
            if (temp[i] < nums2[j])
                nums1[index++] = temp[i++];
            else
                nums1[index++] = nums2[j++];
        while (i < m)
            nums1[index++] = temp[i++];
        while (j < n)
            nums1[index++] = nums2[j++];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int num : nums1)
            System.out.print(num + " ");
    }
}
