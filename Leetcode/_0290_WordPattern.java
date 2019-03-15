package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter
 * in pattern and a non-empty word in str.
 * <p>
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase
 * letters separated by a single space.
 */
public class _0290_WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        if (pattern.length() != s.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!s[i].equals(map.get(pattern.charAt(i))))
                    return false;
            } else if (map.containsValue(s[i])) // 注意！！！
                return false;
            else
                map.put(pattern.charAt(i), s[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";
        System.out.println(wordPattern(pattern, str));
    }
}
