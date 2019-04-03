package DataWhale.Leetcode;

/**
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 * <p>
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class _0583_DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= word2.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= word1.length(); i++)
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(new _0583_DeleteOperationForTwoStrings().minDistance(s1, s2));
    }
}
