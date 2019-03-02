package DataWhale.Leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
public class _0150_EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // 弄清楚哪个在前哪个在后
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (s.equals("+"))
                    stack.push(num1 + num2);
                else if (s.equals("-"))
                    stack.push(num1 - num2);
                else if (s.equals("*"))
                    stack.push(num1 * num2);
                else
                    stack.push(num1 / num2);
            } else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));
    }
}
