package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _0144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }
}
