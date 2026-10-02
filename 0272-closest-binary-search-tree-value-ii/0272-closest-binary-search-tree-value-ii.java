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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, queue, k, target);
        return new ArrayList<>(queue);
    }

    public void dfs(TreeNode root, Deque<Integer> queue, int k, double target) {
        if (root == null) {
            return;
        }
        dfs(root.left, queue, k, target);
        queue.add(root.val);
        if (queue.size() > k) {
            if(Math.abs(queue.peekFirst() - target) <= Math.abs(queue.peekLast() - target)){ 
                queue.pollLast();
            }else{ 
                queue.pollFirst();
            }
        }
        dfs(root.right, queue, k, target);
    }
}