package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
 * numbers on the row below.
 * For example, given the following triangle
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of
 * rows in the triangle.
 */
public class _0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] sum = new int[triangle.size()][triangle.size()];
        sum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0)
                    sum[i][j] = sum[i - 1][j] + list.get(j);
                else if (j == list.size() - 1)
                    sum[i][j] = sum[i - 1][j - 1] + list.get(j);
                else
                    sum[i][j] = Math.min(sum[i - 1][j - 1], sum[i - 1][j]) + list.get(j);
            }
        }
        int min = sum[triangle.size() - 1][triangle.size() - 1];
        for (int i = 0; i < triangle.size(); i++)
            min = sum[triangle.size() - 1][i] < min ? sum[triangle.size() - 1][i] : min;

        return min;
    }
}
