package DataWhale.Leetcode;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _0680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right)
            if (s.charAt(left) != s.charAt(right))
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            else {
                left++;
                right--;
            }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(new _0680_ValidPalindromeII().validPalindrome(s));
    }
}
