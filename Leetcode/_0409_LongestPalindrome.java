package DataWhale.Leetcode;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 * that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 */
public class _0409_LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0;
        if (s.length() == 0)
            return res;
        int[] count = new int[58];
        for (char c : s.toCharArray())
            count[c - 'A']++;
        int flag = 0;
        for (int num : count) {
            res += num / 2 * 2;
            if (num % 2 != 0)
                flag = 1;
        }
        return res + flag;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new _0409_LongestPalindrome().longestPalindrome(s));
    }
}
