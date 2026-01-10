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
    public List<Integer> postorderTraversal(TreeNode root) {
        
    return postorderDfs(root, new ArrayList<>());
    }
    public List<Integer> postorderDfs(TreeNode root, List<Integer> ans){
        if(root == null) return ans;
        postorderDfs(root.left, ans);
        postorderDfs(root.right,ans);
        ans.add(root.val);
    return ans;
    }
}