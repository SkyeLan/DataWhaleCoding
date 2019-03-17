package DataWhale.Leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits
 * are stored in reverse order and each of their nodes contain a single digit. Add the two
 * numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class _0002_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = null, cur = null;
        Boolean flag = false;
        while (true) {
            int sum = 0;
            int temp = flag ? 1 : 0;
            if (l1 != null && l2 != null) {
                int a = l1.val, b = l2.val;
                sum = a + b + temp;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int a = l1.val;
                sum = a + temp;
                l1 = l1.next;
            } else if (l2 != null) {
                int b = l2.val;
                sum = b + temp;
                l2 = l2.next;
            } else {
                if (temp == 1)
                    cur.next = new ListNode(1);
                break;
            }
            flag = sum >= 10;
            if (newNode == null) {
                newNode = new ListNode(sum % 10);
                cur = newNode;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        System.out.println(addTwoNumbers(l1, l2).toString());
    }
}
