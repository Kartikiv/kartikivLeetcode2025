class Solution {
    public int findSecondMinimumValue(TreeNode root) {
      
      long ans = dfsHelper(root, root.val);

        return ans == Long.MAX_VALUE ? -1 : (int) ans ;
    }
    public long dfsHelper(TreeNode root, int min){
        if(root == null) return Long.MAX_VALUE;
        if(root.val > min){
          return root.val;
        } 
        long left = dfsHelper(root.left, min);
        long right = dfsHelper(root.right, min);
        return Math.min(left, right);
    }
}