package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class _0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        for (int i = 1; i < list.size(); i++)
            if (list.get(i - 1) >= list.get(i))
                return false;
        return true;
    }
}
