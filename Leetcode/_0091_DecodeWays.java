package DataWhale.Leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class _0091_DecodeWays {
    public static int numDecodings(String s) {
        int[] count = new int[s.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            if (i == 1) {
                if (s.charAt(0) == '0')
                    return 0;
                count[1] = 1;
            } else if (i == 2) {
                if (s.charAt(0) > '2' && s.charAt(1) == '0')
                    return 0;
                else if (s.charAt(1) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26)
                    count[2] = 2;
                else
                    count[2] = 1;
            } else {
                if (s.charAt(i - 1) != '0') {
                    count[i] += count[i - 1];
                }
                if (Integer.valueOf(s.substring(i - 2, i)) <= 26 && s.charAt(i - 2) != '0') {
                    count[i] += count[i - 2];
                }
            }
        }
        return count[s.length()];
    }

    public static void main(String[] args) {
        String s = "301";
        System.out.println(numDecodings(s));
    }
}
