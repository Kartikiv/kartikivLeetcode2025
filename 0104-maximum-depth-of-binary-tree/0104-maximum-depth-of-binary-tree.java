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
    int maxDepth; 
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helperDfs(root, 1);
       return maxDepth; 
    }
    void helperDfs(TreeNode root, int depth){
        if(root == null) return; 
        helperDfs(root.left, depth + 1);
        helperDfs(root.right, depth + 1);
        maxDepth = Math.max(depth, maxDepth);

    }
}