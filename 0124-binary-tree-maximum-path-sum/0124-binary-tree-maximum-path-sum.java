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
class Solution {
    int maxAns;

    public int maxPathSum(TreeNode root) {
        maxAns = Integer.MIN_VALUE;
        dfs(root);
        return maxAns;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int maxRight = dfs(root.right);
        int maxLeft = dfs(root.left);
        int currmax = Math.max(root.val + maxRight, root.val + maxLeft);
        currmax = Math.max(root.val, currmax);
        maxAns = Math.max(maxLeft + maxRight + root.val, maxAns);
        maxAns = Math.max(maxAns, currmax);
        

        return currmax;
    }
}