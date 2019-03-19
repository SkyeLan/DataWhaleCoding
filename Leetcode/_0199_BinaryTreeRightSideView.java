package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the
 * values of the nodes you can see ordered from top to bottom.
 */
public class _0199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int count = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int last = -1;
            while (count < size) {
                TreeNode cur = q.poll();
                count++;
                last = cur.val;
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            list.add(last);
            count = 0;
        }
        return list;
    }
}
