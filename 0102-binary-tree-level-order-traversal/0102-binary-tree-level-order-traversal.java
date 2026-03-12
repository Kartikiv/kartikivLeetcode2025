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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(1);
        dfs(root, ans, 0);
        return ans;
    }

    void dfs(TreeNode root, List<List<Integer>> ans, int depth) {
        if (root == null)
            return;
        if (ans.size() == depth)
            ans.add(new ArrayList<>());
        ans.get(depth).add(root.val);
        dfs(root.left, ans, depth + 1);
        dfs(root.right, ans, depth + 1);

    }
}