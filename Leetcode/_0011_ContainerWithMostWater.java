package DataWhale.Leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class _0011_ContainerWithMostWater {
    public static int maxArea(int[] height) {
//        int maxA = 0;
//        for (int i = 0; i < height.length; i++)
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * (height[j] > height[i] ? height[i] : height[j]);
//                if (area > maxA)
//                    maxA = area;
//            }
//        return maxA;

        int maxA = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * (height[right] > height[left] ? height[left] : height[right]);
            if (area > maxA)
                maxA = area;
            if (height[right] > height[left])
                left++;
            else
                right--;
        }
        return maxA;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }
}
