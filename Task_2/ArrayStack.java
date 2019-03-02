package DataWhale.Task2;

/**
 * 用数组实现一个顺序栈
 */
public class ArrayStack {
    public int size;
    public int[] stack;

    public ArrayStack(int capacity) {
        size = 0;
        stack = new int[capacity];
    }

    public void push(int num) {
        if (size == stack.length)
            throw new IndexOutOfBoundsException("栈满了");
        stack[size++] = num;
    }

    public int pop() {
        if (size == 0)
            throw new NullPointerException("栈空的");
        return stack[--size];
    }

    public int peek() {
        if (size == 0)
            throw new NullPointerException("栈空的");
        return stack[size - 1];
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = size; i > 0; i--) {
            res.append(stack[i - 1]);
            if (i != 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(10);
        s.push(15);
        s.push(88);
        s.push(58);
        s.push(66);
        System.out.println(s.toString());
        System.out.println("出栈: " + s.pop());
        System.out.println("栈顶元素：" + s.peek());
    }
}
