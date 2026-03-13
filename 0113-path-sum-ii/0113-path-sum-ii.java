
import java.lang.classfile.constantpool.IntegerEntry;

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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.ans = new ArrayList<>();
        dfs(root, targetSum, 0, new LinkedList<>());
        return ans;

    }

    void dfs(TreeNode root, int targetSum, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new LinkedList<>(list));
            }
        }
      
        dfs(root.left, targetSum, sum, list);
        dfs(root.right, targetSum, sum, list);
        list.removeLast();

    }
}