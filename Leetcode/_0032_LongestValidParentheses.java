package DataWhale.Leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find
 * the length of the longest valid (well-formed) parentheses substring.
 */
public class _0032_LongestValidParentheses {
    /**
     * 创建栈，存放括号的下标
     * 如果左括号，入栈
     * 如果右括号
     * 1. 栈顶是左括号，出栈，最长序列为当前下标减栈顶元素下标
     * 2. 栈顶右括号，入栈
     * 3. 栈空，入栈
     * <p>
     * **注意**：出栈后栈空时长度的计算
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else if (stack.isEmpty() || s.charAt(stack.peek()) == ')')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty())
                    res = res > i + 1 ? res : i + 1;
                else
                    res = res > i - stack.peek() ? res : i - stack.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
