package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 */
public class _0107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(lists);
        return lists;
    }
}
