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
import java.util.*;
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null ) return 0; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        int level = 0 ; 
        int maxSum = Integer.MIN_VALUE; 
        int maxLevel = 0 ; 
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            int sum = 0; 
            level++;
            for(int i = 0 ; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
            if(sum > maxSum){
                maxLevel = level; 
                maxSum = sum; 
            }
        }
    return maxLevel; 
    }
}