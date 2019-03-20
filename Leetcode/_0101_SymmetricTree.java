package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class _0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if ((node1 == null && node2 != null) || (node1 != null && node2 == null))
                return false;
            if (node1 != null && node2 != null) {
                if (node1.val != node2.val)
                    return false;
                q1.add(node1.left);
                q1.add(node1.right);
                q2.add(node2.right);
                q2.add(node2.left);
            }
        }
        return true;
    }
}
