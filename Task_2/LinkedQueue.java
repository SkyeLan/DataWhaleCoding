package DataWhale.Task2;

/**
 * 用链表实现一个队列
 */
public class LinkedQueue {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    private int size;
    private ListNode head;
    private ListNode tail;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    public void enqueue(ListNode node2) {
        if (size == 0) {
            head = tail = node2;
        } else {
            tail.next = node2;
            tail = node2;
        }
        size++;
    }

    public ListNode dequeue() {
        ListNode temp = head;
        head = head.next;
        size--;
        temp.next = null;
        return temp;
    }

    public ListNode getFirst() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        ListNode temp = head;
        for (int i = 0; i < size; i++) {
            res.append(temp.val);
            temp = temp.next;
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(new ListNode(1));
        queue.enqueue(new ListNode(2));
        queue.enqueue(new ListNode(3));
        queue.enqueue(new ListNode(4));
        System.out.println(queue.toString());
        System.out.println("出队: " + queue.dequeue().val);
        System.out.println("出队: " + queue.dequeue().val);
        System.out.println("队首元素：" + queue.getFirst().val);
    }
}
