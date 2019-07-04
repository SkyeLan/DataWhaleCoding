package DataWhale.Leetcode;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.
 */
public class _0633_SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a + b * b < c)
                a++;
            else if (a * a + b * b > c)
                b--;
            else
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int target = 5;
        System.out.println(judgeSquareSum(target));
    }
}
