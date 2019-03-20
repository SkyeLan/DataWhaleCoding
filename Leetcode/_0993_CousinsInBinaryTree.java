package DataWhale.Leetcode;

import java.util.*;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * Note:
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class _0993_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)))
                    return false;
                if (node.left != null) {
                    queue.add(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    list.add(node.right.val);
                }
            }
            if (list.contains(x) && list.contains(y))
                return true;
        }
        return false;
    }
}
