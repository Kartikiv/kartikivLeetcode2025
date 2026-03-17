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
    public int findSecondMinimumValue(TreeNode root) {
        long secondSmallest = Long.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {

               
                    queue.add(node.right);
                    if (node.left.val != root.val)
                        secondSmallest = Math.min(secondSmallest, node.left.val);
                

              
                    if (node.right.val != root.val)
                        secondSmallest = Math.min(secondSmallest, node.right.val);
                    queue.add(node.left);
                
            }
        }
        return secondSmallest == Long.MAX_VALUE ? -1 : (int)secondSmallest;
    }
}