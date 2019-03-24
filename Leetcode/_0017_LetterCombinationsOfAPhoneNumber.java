package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * <p>
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class _0017_LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;
        list = letterCombinations(digits.substring(0, digits.length() - 1));
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] cs = map.get(digits.charAt(digits.length() - 1));
        if (list.isEmpty()) {
            for (char c : cs)
                list.add(c + "");
        } else {
            List<String> list2 = new ArrayList<>();
            for (String s : list)
                for (char c : cs)
                    list2.add(s + c);
            list = list2;
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }
}
