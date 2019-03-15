package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class _0451_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        String[] times = new String[s.length() + 1];
        for (char key : map.keySet())
            if (times[map.get(key)] != null)
                times[map.get(key)] += key;
            else
                times[map.get(key)] = key + "";
        StringBuffer sb = new StringBuffer();
        for (int i = times.length - 1; i >= 0; i--)
            if (times[i] != null)
                for (char cc : times[i].toCharArray())
                    for (int j = 0; j < i; j++)
                        sb.append(cc);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
