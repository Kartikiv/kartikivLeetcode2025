
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans;
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.ans = 0 ;
        this.targetSum = targetSum;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);  
        dfs(root, 0l, map);
        return ans;
    }

    void dfs(TreeNode root, long sum, HashMap<Long, Integer> map) {
        if (root == null)
            return;
        sum += root.val;
        if (map.containsKey(sum - targetSum))
            ans += map.get(sum - targetSum);
        int count = map.getOrDefault(sum, 0)  + 1;
        map.put(sum, count);
        dfs(root.left, sum, map);
        dfs(root.right, sum, map);
        count = map.getOrDefault(sum, 0) - 1;
        if(count <= 0 ){
             map.remove(sum);
        }else{
            map.put(sum, count);
        }

    }
}