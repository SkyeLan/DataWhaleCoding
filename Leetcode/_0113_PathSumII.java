package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 */
public class _0113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return lists;
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(0, root.val);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> leftPath = pathSum(root.left, sum - root.val);
        if (leftPath.size() > 0)
            for (List<Integer> l : leftPath) {
                l.add(0, root.val);
                lists.add(l);
            }
        List<List<Integer>> rightPath = pathSum(root.right, sum - root.val);
        if (rightPath.size() > 0)
            for (List<Integer> l : rightPath) {
                l.add(0, root.val);
                lists.add(l);
            }

        return lists;
    }
}
