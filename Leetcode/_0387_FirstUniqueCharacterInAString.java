package DataWhale.Leetcode;

/**
 * Given a string, find the first non-repeating character in it and
 * return it's index. If it doesn't exist, return -1.
 * <p>
 * Note: You may assume the string contain only lowercase letters.
 */
public class _0387_FirstUniqueCharacterInAString {
    // 只有小写字母，建立26个字母的数组，存储频率
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
