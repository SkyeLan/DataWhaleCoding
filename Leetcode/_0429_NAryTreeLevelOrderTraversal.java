package DataWhale.Leetcode;

import java.util.*;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Note:
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class _0429_NAryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> leelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root== null)
            return lists;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            lists.add(list);
        }
        return lists;
    }
}
