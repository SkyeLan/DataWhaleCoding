package DataWhale.Leetcode;

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class _0404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.left != null)
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        if (root.right != null)
            sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
