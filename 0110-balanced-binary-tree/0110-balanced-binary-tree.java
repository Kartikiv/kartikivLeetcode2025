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
    boolean ans; 
    public boolean isBalanced(TreeNode root) {
        this.ans = true;
        helper(root);
        return ans; 

    }
    int helper(TreeNode root){
        if(root == null) return 0; 

        int left = helper(root.left); 
        int right = helper(root.right); 
        ans = ans == false ? false : Math.abs(left - right) <= 1; 

        return 1 + Math.max(left, right);
        
    }
}