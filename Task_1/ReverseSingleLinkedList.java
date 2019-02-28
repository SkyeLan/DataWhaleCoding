package DataWhale.Task1;

public class ReverseSingleLinkedList {
    public class Node {
        int index;
        Node next;

        public Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }
    }

    /**
     * 翻转单链表
     */
    public Node reverseSingleLinkedList(Node head){
        if(head.next==null)
            return head;
        Node next = head.next;
        Node re = reverseSingleLinkedList(next);

        head.next = null;
        next.next = head;
        return re;
    }
}
