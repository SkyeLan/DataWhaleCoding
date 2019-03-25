package DataWhale.Leetcode;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize
 * the product of those integers. Return the maximum product you can get.
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class _0343_IntegerBreak {
    public static int integerBreak(int n) {
        int[] cj = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 1 || i == 2)
                cj[i] = 1;
            else {
                int max = Integer.MIN_VALUE;
                for (int j = 1; j < i; j++) {
                    max = max > cj[i - j] * j ? max : cj[i - j] * j;
                    // 注意直接拆分成两部分乘积的情况
                    max = max > (i - j) * j ? max : (i - j) * j;
                }
                cj[i] = max;
            }
        }
        return cj[n];
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(integerBreak(a));
    }
}
