/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Inverts a binary tree by swapping the left and right children of each node.
 * 
 * This method recursively traverses the tree and inverts it in-place.
 * For each node, it swaps its left and right subtrees, then recursively
 * inverts those subtrees.
 * 
 * @param root the root node of the binary tree to invert
 * @return the root of the inverted tree
 * 
 * Time Complexity: O(n) where n is the number of nodes in the tree,
 *                  as each node is visited exactly once
 * Space Complexity: O(h) where h is the height of the tree,
 *                   due to the recursive call stack
 */
class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode tempLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempLeft);

        return  root;
    }
}