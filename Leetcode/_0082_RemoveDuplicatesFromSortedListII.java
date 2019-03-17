package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 */
public class _0082_RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (map.containsKey(cur.next.val))
                map.put(cur.next.val, map.get(cur.next.val) + 1);
            else
                map.put(cur.next.val, 1);
            cur = cur.next;
        }
        cur = dummyNode;
        while (cur.next != null) {
            if (map.get(cur.next.val) > 1)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println(deleteDuplicates(head).toString());
    }
}
