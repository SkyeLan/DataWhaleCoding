package DataWhale.Leetcode;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a
 * very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one
 * by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
public class _0392_IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length() || s.length() == 0)
            return false;
        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(index))
                index++;
            if (index == s.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
