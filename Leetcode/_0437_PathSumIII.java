package DataWhale.Leetcode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling
 * only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class _0437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    // 寻找以node为根节点的二叉树中，包含node的路径且和为sum的个数。
    public int findPath(TreeNode node, int sum) {
        if (node == null)
            return 0;
        int res = 0;
        if (node.val == sum)
            res++;

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }
}
