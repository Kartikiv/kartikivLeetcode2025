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
/**
 * Determines whether two binary trees are identical.
 * 
 * Two trees are considered the same if they have the same structure and 
 * the same node values at each corresponding position.
 * 
 * @param p the root node of the first binary tree
 * @param q the root node of the second binary tree
 * @return true if both trees are identical (same structure and values), 
 *         false otherwise
 * 
 * Time Complexity: O(min(m, n)) where m and n are the number of nodes in 
 *                  trees p and q respectively
 * Space Complexity: O(min(h1, h2)) where h1 and h2 are the heights of the 
 *                   trees due to recursion call stack
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;


        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);


    }
}