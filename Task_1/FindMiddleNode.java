package DataWhale.Task1;

import java.util.LinkedList;

public class FindMiddleNode<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    /**
     * 寻找链表的中间节点
     */
    public Node findMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null)
            return slow;
        else
            return slow.next;
    }
}
