package DataWhale.Leetcode;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * <p>
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate
 * a stack by using a list or deque (double-ended queue), as long as you use only
 * standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 */
public class _0232_ImplementQueueUsingStacks {
    static class MyQueue {
        public Stack<Integer> in;
        public Stack<Integer> out;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!in.isEmpty())
                out.push(in.pop());
            int temp = out.pop();
            while (!out.isEmpty())
                in.push(out.pop());
            return temp;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!in.isEmpty())
                out.push(in.pop());
            int temp = out.peek();
            while (!out.isEmpty())
                in.push(out.pop());
            return temp;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return in.isEmpty();
        }
    }


    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
