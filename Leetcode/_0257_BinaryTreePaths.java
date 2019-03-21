package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 */
public class _0257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String s : leftPaths)
            list.add(root.val+"->"+s);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths)
            list.add(root.val+"->"+s);

        return list;
    }
}
