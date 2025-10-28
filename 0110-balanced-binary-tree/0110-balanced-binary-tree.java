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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
     if (root == null ) return true;
         
    return depth(root) == -1? false : true;}
    public int depth (TreeNode root){
        if (root == null ) return 0;
        int x = depth(root.left);
        int y = depth(root.right);
        if(x == -1 || y == -1) return -1;
        if( Math.abs(x - y) > 1){
            
            return -1;
        }
    return Math.max(x, y ) +1 ;
    }
    
}