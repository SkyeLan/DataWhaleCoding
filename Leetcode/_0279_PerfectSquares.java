package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class _0279_PerfectSquares {
    public static int numSquares(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == 1)
                count[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++)
                    min = min < count[i - j * j] + 1 ? min : count[i - j * j] + 1;
                count[i] = min;
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
