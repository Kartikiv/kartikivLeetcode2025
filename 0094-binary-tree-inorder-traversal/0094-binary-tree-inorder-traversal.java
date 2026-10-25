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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>(); 
        
        List<Integer> inorderList = new ArrayList<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode node = stack.pop(); 
            if(node.right != null && node.right != lastVisited){
                current = node.right;
            }
            inorderList.add(node.val);
            
        }
    return inorderList; 
    }
}