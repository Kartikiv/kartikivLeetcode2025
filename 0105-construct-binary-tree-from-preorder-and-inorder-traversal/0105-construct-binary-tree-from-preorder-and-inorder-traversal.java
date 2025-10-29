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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        int[] left = Arrays.copyOfRange(inorder, 0, index);
        int[] right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + index);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
        root.left = buildTree(preLeft, left);
        root.right = buildTree(preRight, right);

        return root;
    }

    public int findIndex(int[] inorder, int target) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                index = i;
                break;
            }
        }

        return index;
    }

}