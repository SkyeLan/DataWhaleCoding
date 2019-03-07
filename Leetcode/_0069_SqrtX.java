package DataWhale.Leetcode;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed
 * to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are
 * truncated and only the integer part of the result is returned.
 */
public class _0069_SqrtX {
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid)
                left = mid + 1;
            else if (mid > x / mid)
                right = mid - 1;
            else
                return mid;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
