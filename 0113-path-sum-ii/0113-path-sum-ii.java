
class Solution {
    static class Frame {
        TreeNode node;
        boolean exit;

        Frame(TreeNode node, boolean exit) {
            this.node = node;
            this.exit = exit;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> path = new ArrayList<>();
        Deque<Frame> stack = new ArrayDeque<>();

        stack.push(new Frame(root, false));
        long sum = 0;

        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            TreeNode node = frame.node;

            if (frame.exit) {
                // Backtrack after processing both children
                sum -= node.val;
                path.remove(path.size() - 1);
                continue;
            }

            // Enter node
            path.add(node.val);
            sum += node.val;

            if (node.left == null && node.right == null
                    && sum == targetSum) {
                result.add(new ArrayList<>(path));
            }

            // Exit after both subtrees
            stack.push(new Frame(node, true));

            // Right first so left is processed first
            if (node.right != null) {
                stack.push(new Frame(node.right, false));
            }

            if (node.left != null) {
                stack.push(new Frame(node.left, false));
            }
        }

        return result;
    }
}
