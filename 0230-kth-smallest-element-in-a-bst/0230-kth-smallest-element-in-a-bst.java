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
    // we can use controlled inorder travesal\
    int ans ;
    int k ;
    public int kthSmallest(TreeNode root, int k) {
        this.ans = Integer.MAX_VALUE; 
        this.k = k ;
        helper(root);
        return ans;
    }
    void helper(TreeNode root){
        if(root == null ) return ;
        helper(root.left);
        if(k > 0){
            ans = root.val;
            k--;
        }else{
            return; 
        }
        helper(root.right);
    }
}