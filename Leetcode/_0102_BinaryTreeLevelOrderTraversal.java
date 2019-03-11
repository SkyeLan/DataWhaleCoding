package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its
 * nodes' values. (ie, from left to right, level by level).
 */
public class _0102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        int count = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (count < size) {
                TreeNode node = q.remove();
                count++;
                list.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            lists.add(list);
            count = 0;
        }
        return lists;
    }
}
