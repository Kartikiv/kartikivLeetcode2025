class Solution {
    long secondMin = Long.MAX_VALUE;
    int min;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        min = root.val;
        dfs(root);

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        // candidate for second minimum
        if (node.val > min && node.val < secondMin) {
            secondMin = node.val;
        }

        // pruning (important optimization)
        if (node.val == min) {
            dfs(node.left);
            dfs(node.right);
        }
    }
}