package DataWhale.Leetcode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return
 * the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 */
public class _0450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        while (root.val == key && root.left != null) {
            TreeNode node = root.left, pre = node;
            while (node.right != null) {
                pre = node;
                node = node.right;
            }
            pre.right = node.left;
            if (node != root.left)
                node.left = root.left;
            node.right = root.right;
            root = node;
        }
        while (root.val == key && root.right != null)
            root = root.right;
        while (root.val == key)
            return null;
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
}
