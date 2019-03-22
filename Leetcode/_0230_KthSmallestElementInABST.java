package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class _0230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                index++;
                if (index == k)
                    return node.val;
                node = node.right;
            }
        }
        return -1;
    }
}
