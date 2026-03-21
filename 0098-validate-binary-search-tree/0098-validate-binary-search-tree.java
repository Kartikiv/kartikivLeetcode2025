class Solution {
    private Long prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (!inorder(root.left)) return false;

        if (prev != null && root.val <= prev) return false;
        prev = (long) root.val;

        return inorder(root.right);
    }
}