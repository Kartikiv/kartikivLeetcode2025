/**
 * Definition for a binary tree node.
 */
class Solution {

    // Global flag to track whether the tree remains balanced
    private boolean isBalanced = true;

    /**
     * Determines whether a binary tree is height-balanced.
     *
     * A binary tree is balanced if for every node, the height difference
     * between its left and right subtrees is at most 1.
     *
     * @param root the root of the binary tree
     * @return true if the tree is height-balanced, false otherwise
     */
    public boolean isBalanced(TreeNode root) {
        computeHeight(root);
        return isBalanced;
    }

    /**
     * Computes the height of the subtree rooted at the given node.
     *
     * While computing height, this method also checks whether the subtree
     * is balanced by comparing the heights of left and right subtrees.
     *
     * @param root the current tree node
     * @return the height of the subtree rooted at {@code root}
     */
    private int computeHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

