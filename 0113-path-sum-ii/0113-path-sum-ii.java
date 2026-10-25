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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode curr = root; 
        TreeNode lastVisited = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            
            while (curr != null) {
                stack.add(curr);
                path.add(curr.val);
                sum += curr.val;
                curr = curr.left; 
            }
            TreeNode node = stack.peek();
            // 3. Explore right subtree if not processed
            if (node.right != null && lastVisited != node.right) {
                curr = node.right;
            } else {

                // 4. Process leaf
                if (node.left == null && node.right == null
                        && sum == targetSum) {
                    ans.add(new ArrayList<>(path));
                }

                // 5. Backtrack
                stack.pop();
                lastVisited = node;

                sum -= node.val;
                path.remove(path.size() - 1);
            }

        }
    return ans; 
    }
}