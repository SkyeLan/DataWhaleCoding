package DataWhale.Task2;

/**
 * 用链表实现一个链式栈
 */
public class LinkedStack {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int size;
    public ListNode node;

    public LinkedStack() {
        node = null;
        size = 0;
    }

    public void push(ListNode node2) {
        node2.next = node;
        node = node2;
        size++;
    }

    public ListNode pop() {
        ListNode temp = node;
        node = node.next;
        size--;
        temp.next = null;
        return temp;
    }

    public ListNode peek() {
        return node;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        ListNode temp = node;
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
        LinkedStack stack = new LinkedStack();
        stack.push(new ListNode(1));
        stack.push(new ListNode(2));
        stack.push(new ListNode(3));
        stack.push(new ListNode(4));
        System.out.println(stack.toString());
        System.out.println("出栈: " + stack.pop().val);
        System.out.println("出栈: " + stack.pop().val);
        System.out.println("栈顶元素：" + stack.peek().val);
    }
}
