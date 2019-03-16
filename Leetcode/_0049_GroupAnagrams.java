package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class _0049_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            if (map.containsKey(String.valueOf(sc)))
                map.get(String.valueOf(sc)).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(String.valueOf(sc), list);
            }
        }
        for (String key : map.keySet())
            lists.add(map.get(key));
        return lists;
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(s);
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
