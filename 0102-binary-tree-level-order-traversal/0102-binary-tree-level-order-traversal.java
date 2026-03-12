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
 /* 
 BFS : insert in queue and count the children so that we can keep track  
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null ) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0 ; i < n; i++){
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {queue.add(node.left); }
            if (node.right != null){ queue.add(node.right); }
            }
            ans.add(temp);


            
        }
    return ans;}
}