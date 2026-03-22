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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean helper(TreeNode root, Long high, Long low){
        if(root == null) return true; 
        if(root.val >= high || root.val <= low) return false;
        boolean left = helper(root.left, (long)root.val, low);
        boolean right = helper(root.right, high, (long)root.val); 
        

        return left && right;

    }
}