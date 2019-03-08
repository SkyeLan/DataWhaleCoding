package DataWhale.Leetcode;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the
 * sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers.
 */
public class _0202_HappyNumber {
    HashSet<Integer> set = new HashSet<>();

    // 看看变化的过程中，是否出现重复，若出现，则代表不是快乐数
    // 如果不是快乐数，那循环就是无限的
    public boolean isHappy(int n) {
        if (set.contains(n))
            return false;
        if (n == 1)
            return true;
        set.add(n);
        int next = 0;
        while (n > 0) {
            next += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return isHappy(next);
    }

    public static void main(String[] args) {
        int num = 98;
        System.out.println(new _0202_HappyNumber().isHappy(num));
    }
}
