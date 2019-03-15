package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p
 * will not be larger than 20,100.
 * The order of output does not matter.
 */
public class _0438_FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return list;
        int[] pChar = new int[26];
        for (char c : p.toCharArray())
            pChar[c - 'a']++;
        int i = 0, j = 0, rest = p.length();
        //把窗口扩成p串的长度
        while (j < p.length()) {
            char temp = s.charAt(j);
            pChar[temp - 'a']--;
            if (pChar[temp - 'a'] >= 0)
                rest--;
            j++;
        }
        if (rest == 0)
            list.add(i);
        //开始一步一步向右移动窗口
        while (j < s.length()) {
            //左边的拿出来一个
            char temp = s.charAt(i);
            if (pChar[temp - 'a'] >= 0)
                rest++;
            pChar[temp - 'a']++;
            i++;

            //右边的拿进来一个
            char temp2 = s.charAt(j);
            pChar[temp2 - 'a']--;
            if (pChar[temp2 - 'a'] >= 0)
                rest--;
            j++;
            if (rest == 0)
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p).toString());
    }
}
