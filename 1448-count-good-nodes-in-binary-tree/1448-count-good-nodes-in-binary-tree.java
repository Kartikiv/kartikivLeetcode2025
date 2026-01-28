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
    int ans = 0 ;
    int rootVal;
    public int goodNodes(TreeNode root) {
       rootVal = root.val;
       dfs(root, Integer.MIN_VALUE);
       return ans;
    }
   public void dfs (TreeNode root, int maxSofar){
    if(root == null) return; 
    if(root.val >= maxSofar){
        ans++;
        maxSofar = root.val;
    }
    dfs(root.right, maxSofar);
    dfs(root.left, maxSofar);
}
}