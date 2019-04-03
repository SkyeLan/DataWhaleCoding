package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class _0513_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            left = queue.peek();
            while (count < size) {
                TreeNode node = queue.poll();
                count++;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return left.val;
    }
}
