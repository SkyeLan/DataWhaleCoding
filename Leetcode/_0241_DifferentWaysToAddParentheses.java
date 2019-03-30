package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 */
public class _0241_DifferentWaysToAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if (input.length() == 0)
            return list;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                String pre = input.substring(0, i);
                String follow = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(pre);
                List<Integer> right = diffWaysToCompute(follow);
                for (int num1 : left)
                    for (int num2 : right)
                        switch (cur) {
                            case '+':
                                list.add(num1 + num2);
                                break;
                            case '-':
                                list.add(num1 - num2);
                                break;
                            case '*':
                                list.add(num1 * num2);
                                break;
                            default:
                                break;
                        }
            }
        }
        if (list.size() == 0)
            list.add(Integer.valueOf(input));
        return list;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        System.out.println(diffWaysToCompute(input).toString());
    }
}
