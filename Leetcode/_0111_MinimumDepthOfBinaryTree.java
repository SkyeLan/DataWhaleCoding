package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class _0111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        Boolean flag = false; // 右子树未出现空缺
        while (!queue.isEmpty()) {
            int count = 0;
            int size = queue.size();
            depth++;
            while (count < size) {
                TreeNode node = queue.poll();
                count++;
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return depth;
    }
}
