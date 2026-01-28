/**
 * Solution for counting good nodes in a binary tree.
 * A node is considered "good" if the value of the node is greater than or equal
 * to
 * the maximum value seen on the path from root to that node.
 */
class Solution {
    /**
     * Counts the number of good nodes in a binary tree.
     * A good node is one where its value is >= the maximum value on the path from
     * root.
     *
     * @param root the root node of the binary tree
     * @return the total count of good nodes in the tree
     * @time O(n) where n is the number of nodes in the tree
     * @space O(h) where h is the height of the tree (recursion stack)
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    /**
     * Helper method that performs depth-first search to count good nodes.
     *
     * @param node     the current node being processed
     * @param maxSoFar the maximum value seen from root to the parent of current
     *                 node
     * @return the count of good nodes in the subtree rooted at the current node
     */
    private int dfs(TreeNode node, int maxSoFar) {

        if (node == null)
            return 0;

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        return count
                + dfs(node.left, maxSoFar)
                + dfs(node.right, maxSoFar);
    }
}
