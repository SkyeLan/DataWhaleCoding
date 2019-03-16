package DataWhale.Leetcode;

import java.util.*;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there
 * are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be
 * at most 2^31 - 1.
 */
public class _0454_4SumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 先把CD中的所有可能和放进一个map
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : C)
            for (int d : D)
                if (map.containsKey(c + d))
                    map.put(c + d, map.get(c + d) + 1);
                else
                    map.put(c + d, 1);
        int count = 0;
        // 遍历AB，看是不是有刚好的值
        for (int a : A)
            for (int b : B)
                if (map.containsKey(0 - a - b))
                    count += map.get(0 - a - b);
        return count;
    }


    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(fourSumCount(A, B, C, D));
    }
}
