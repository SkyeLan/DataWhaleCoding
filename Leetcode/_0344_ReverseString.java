package DataWhale.Leetcode;

/**
 * Write a function that reverses a string. The input string is given as
 * an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 */
public class _0344_ReverseString {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        reverseString(c);
        for (char cc : c)
            System.out.print(cc + " ");
    }
}
