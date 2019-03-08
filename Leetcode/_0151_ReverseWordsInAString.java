package DataWhale.Leetcode;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * Note:
 * 1. A word is defined as a sequence of non-space characters.
 * 2. Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * 3. You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 */
public class _0151_ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int right = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i + 1 < s.length() && s.charAt(i + 1) == ' ') {
                    right = i;
                    continue;
                }
                if (sb.length() != 0)
                    sb.append(" ");
                for (int j = i + 1; j < right; j++)
                    sb.append(s.charAt(j));
                right = i;
            } else if (i == 0 && s.charAt(i) != ' ') {
                if (sb.length() != 0)
                    sb.append(" ");
                for (int j = i; j < right; j++)
                    sb.append(s.charAt(j));
                right = i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(reverseWords(s));
    }
}
