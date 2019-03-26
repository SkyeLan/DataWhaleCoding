package DataWhale.Leetcode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this
 * area, called the "root." Besides the root, each house has one and only one parent house. After a
 * tour, the smart thief realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class _0337_HouseRobberIII {
    public int rob(TreeNode root) {
//        if (root == null)
//            return 0;
//        int l = 0, ll = 0, lr = 0, r = 0, rl = 0, rr = 0;
//        if (root.left != null) {
//            l = rob(root.left);
//            if (root.left.left != null)
//                ll = rob(root.left.left);
//            if (root.left.right != null)
//                lr = rob(root.left.right);
//        }
//        if (root.right != null) {
//            r = rob(root.right);
//            if (root.right.left != null)
//                rl = rob(root.right.left);
//            if (root.right.right != null)
//                rr = rob(root.right.right);
//        }
//        return Math.max(l + r, ll + lr + rl + rr + root.val);

        if (root == null)
            return 0;
        return Math.max(count(root)[0], count(root)[1]);
    }

    private int[] count(TreeNode root) {
        int[] dp = new int[]{0, 0};  // dp[0] 偷当前层， dp[1] 不偷当前层
        if (root == null)
            return dp;
        int[] left = count(root.left);
        int[] right = count(root.right);
        dp[0] = root.val + left[1] + right[1];
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}
