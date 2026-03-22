class Solution {
    int ans;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }

    void helper(TreeNode root) {
        if (root == null || k == 0) return;

        helper(root.left);

        if (k == 0) return;

        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }

        helper(root.right);
    }
}