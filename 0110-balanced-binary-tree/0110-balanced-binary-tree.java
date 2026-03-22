class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) return -1;   // stop immediately

        int right = helper(root.right);
        if (right == -1) return -1;  // stop immediately

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}