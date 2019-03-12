package DataWhale.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class _0242_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        for (char c : t.toCharArray())
            if (map.containsKey(c)) {
                if(map.get(c)==1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            } else
                return false;
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
