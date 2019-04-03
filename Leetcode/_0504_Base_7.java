package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an integer, return its base 7 string representation.
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class _0504_Base_7 {
    public String convertToBase7(int num) {
        List<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        if (num < 0) {
            sb.append("-");
            num = 0 - num;
        }
        if (num == 0)
            return "0";
        while (num > 0) {
            list.add(0, num % 7);
            num = num / 7;
        }

        for (int n : list)
            sb.append(n);
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println(new _0504_Base_7().convertToBase7(num));
    }
}
