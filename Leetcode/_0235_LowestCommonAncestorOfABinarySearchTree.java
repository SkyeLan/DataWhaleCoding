package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
 * nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to
 * be a descendant of itself).”
 * <p>
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class _0235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node;
        if (p.val > q.val) {
            node = p;
            p = q;
            q = node;
        }
        node = p;
        while (node.right != null)
            node = node.right;
        if (node.val >= q.val)
            return p;   // q在p的右子树,否则，p在q的左边
        node = q;
        while (node.left != null)
            node = node.left;
        if (node.val <= p.val)
            return q; // p在q的左子树,否则，p在q的左边
        // ---------pq不在以对方为根的子树
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        node = root;
        while (true)
            if (node.val < p.val) {
                listp.add(node);
                node = node.right;
            } else if (node.val > p.val) {
                listp.add(node);
                node = node.left;
            } else
                break;
        node = root;
        while (true)
            if (node.val < q.val) {
                listq.add(node);
                node = node.right;
            } else if (node.val > q.val) {
                listq.add(node);
                node = node.left;
            } else
                break;
        for (int i = listq.size() - 1; i >= 0; i--)
            if (listp.contains(listq.get(i)))
                return listq.get(i);
        return null;
    }
}
