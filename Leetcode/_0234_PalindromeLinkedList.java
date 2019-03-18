package DataWhale.Leetcode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class _0234_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy.next, fast = dummy.next.next;
        // 找到中间节点 ----------
        while (fast != null && fast.next != null) {
            slow = slow.next;  // 最终的slow相当于后半段的虚拟头结点
            fast = fast.next.next;
        }
        // 翻转链表 --------------
        ListNode temp, rever = null, cur = slow.next;
        while (cur != null) {
            temp = cur.next;
            cur.next = rever;
            rever = cur;
            cur = temp;
        }
        slow.next = rever;
        // -----------------------
        while (slow.next != null) {
            if (head.val != slow.next.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1});
        System.out.println(isPalindrome(head));
    }
}
