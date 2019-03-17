package DataWhale.Leetcode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant
 * digit comes first and each of their nodes contain a single digit. Add the two numbers and return it
 * as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class _0445_AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode node = null;
        Boolean flag = false;
        int sum;
        while (!s1.isEmpty() || !s2.isEmpty() || flag) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int temp = flag ? 1 : 0;
            sum = a + b + temp;
            flag = sum >= 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        System.out.println(addTwoNumbers(l1, l2).toString());
    }
}
