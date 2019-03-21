package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 */
public class _0129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<String> list = path(root);
        int sum = 0;
        for (String s : list)
            sum += Integer.valueOf(s);
        return sum;
    }

    public List<String> path(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        if (root.left == null && root.right == null)
            list.add(root.val + "");

        List<String> left = path(root.left);
        for (String s : left)
            list.add(root.val + s);
        List<String> right = path(root.right);
        for (String s : right)
            list.add(root.val + s);

        return list;
    }
}
