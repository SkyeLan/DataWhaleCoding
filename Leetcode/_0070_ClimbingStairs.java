package DataWhale.Leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct
 * ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class _0070_ClimbingStairs {
    /**
     * 思路： 基于题目要求，每次只能一次性走一个台阶，或者两个台阶，所
     * 以能到第n个台阶的情况只有两种：
     * 1. 从第n-1的台阶跨一步到第n台阶
     * 2. 从第n-2的台阶一次性跨两步到第n台阶
     * 定义动态规划函数：f[i] 代表了走到第i个台阶的总共不同的方式个数
     * 因而有方程 f(i) = f(i - 1) + f(i - 2)
     */
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
