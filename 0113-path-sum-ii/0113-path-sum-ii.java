
class TreeNodeModified extends TreeNode {
    TreeNodeModified parent;
    long pathSum;

    TreeNodeModified(TreeNode node, TreeNodeModified parent, long parentSum) {
        super(node.val, node.left, node.right);
        this.parent = parent;
        this.pathSum = parentSum + node.val;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNodeModified> queue = new ArrayDeque<>();
        queue.offer(new TreeNodeModified(root, null, 0));

        while (!queue.isEmpty()) {
            TreeNodeModified node = queue.poll();

            if (node.left == null && node.right == null
                    && node.pathSum == targetSum) {

                LinkedList<Integer> path = new LinkedList<>();
                TreeNodeModified current = node;

                while (current != null) {
                    path.addFirst(current.val);
                    current = current.parent;
                }

                result.add(path);
            }

            if (node.left != null) {
                queue.offer(new TreeNodeModified(
                    node.left, node, node.pathSum
                ));
            }

            if (node.right != null) {
                queue.offer(new TreeNodeModified(
                    node.right, node, node.pathSum
                ));
            }
        }

        return result;
    }
}
