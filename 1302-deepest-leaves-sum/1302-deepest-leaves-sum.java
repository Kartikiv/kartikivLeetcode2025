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
    int sum;
    int maxDepth ;

    public int deepestLeavesSum(TreeNode root) {
        this.sum = 0 ;
        this.maxDepth = 0 ;
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (maxDepth < depth) {
                sum = 0;
                maxDepth = depth;
                sum += root.val;
            } else if(depth == maxDepth) {
                sum += root.val;
            }
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);

    }

}