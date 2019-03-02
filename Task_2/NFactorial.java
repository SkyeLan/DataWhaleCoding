package DataWhale.Task2;

/**
 * 求阶乘 n!
 */
public class NFactorial {
    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
}
