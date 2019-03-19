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
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }
}
