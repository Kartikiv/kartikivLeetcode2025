class Frame {
    TreeNode node;
    boolean visited;

    Frame(TreeNode node, boolean visited) {
        this.node = node;
        this.visited = visited;
    }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        Deque<Frame> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> result = new HashMap<>();

        stack.push(new Frame(root, false));

        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            TreeNode node = frame.node;

            if (!frame.visited) {
                stack.push(new Frame(node, true));

                if (node.right != null)
                    stack.push(new Frame(node.right, false));

                if (node.left != null)
                    stack.push(new Frame(node.left, false));

            } else {
                TreeNode left = result.get(node.left);
                TreeNode right = result.get(node.right);

                if (node == p || node == q) {
                    result.put(node, node);
                } else if (left != null && right != null) {
                    result.put(node, node);
                } else {
                    result.put(node, left != null ? left : right);
                }
            }
        }

        return result.get(root);
    }
}