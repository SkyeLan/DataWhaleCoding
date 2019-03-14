package DataWhale.Leetcode;


import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(left), left);
        int maxL = 1, length;

        while (right + 1 < s.length()) {
            right++;
            if (map.containsKey(s.charAt(right))) {
                int temp = map.get(s.charAt(right));
                for (int i = left; i <= temp; i++)
                    map.remove(s.charAt(i));
                left = temp + 1;
            }
            map.put(s.charAt(right), right);
            length = right - left + 1;
            maxL = maxL > length ? maxL : length;
        }
        return maxL;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
