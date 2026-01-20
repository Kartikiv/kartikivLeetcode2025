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
    int maxPath = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return maxPath;}
    public int dfs(TreeNode root){
        if (root == null ) return 0; 
        if(root.left == null && root.right == null) return 0;
        int left = 0 ;
        int right = 0; 
        if(root.left != null){
         left = dfs(root.left) + 1;
        }
         if(root.right != null){
         right = dfs(root.right) + 1;
         }
        int diameterOfBinaryTree = Math.max(left, right);
        maxPath = Math.max(left + right, maxPath);
        return diameterOfBinaryTree;
    }
}