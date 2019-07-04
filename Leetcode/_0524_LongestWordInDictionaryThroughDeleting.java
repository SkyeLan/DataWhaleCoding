package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some
 * characters of the given string. If there are more than one possible results, return the longest word with the smallest
 * lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class _0524_LongestWordInDictionaryThroughDeleting {
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return 1;
                else if (s1.length() > s2.length())
                    return -1;
                else {
                    return Character.compare(s1.charAt(0), s2.charAt(0));
                }
            }
        });
        for (
                String ss : d) {
            int i = 0, j = 0;
            while (i < s.length()) {
                if (j < ss.length() && s.charAt(i) == ss.charAt(j))
                    j++;
                i++;
            }
            if (j == ss.length())
                return ss;
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "bab";
        List<String> d = Arrays.asList("ba", "ab", "a");
        System.out.println(findLongestWord(s, d));
    }
}
