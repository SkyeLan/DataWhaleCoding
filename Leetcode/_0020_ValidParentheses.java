package DataWhale.Leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class _0020_ValidParentheses {
    /**
     * 遇到{,[,( 就进栈，遇到 },],) 就出栈
     * 如果不匹配，返回false
     * 遍历完如果栈不空，返回false
     */
    public static boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sc)
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if (stack.size() == 0)
                    return false;
                if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[')
                    stack.pop();
                else if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

}
