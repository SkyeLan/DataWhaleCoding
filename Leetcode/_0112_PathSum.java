package DataWhale.Leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class _0112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean flag = false;
        if (root != null) {
            if (root.left == null && root.right == null)
                return sum == root.val;
            if (root.left != null && !flag)
                flag = hasPathSum(root.left, sum - root.val);
            if (root.right != null && !flag)
                flag = hasPathSum(root.right, sum - root.val);
        }
        return flag;
    }
}
