
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;
        TreeNode lastVisited = null;
        long sum = 0;

        while (current != null || !stack.isEmpty()) {

            // Enter nodes along the left path
            while (current != null) {
                stack.push(current);
                path.add(current.val);
                sum += current.val;
                current = current.left;
            }

            TreeNode node = stack.peek();

            // Explore right subtree if not already visited
            if (node.right != null && node.right != lastVisited) {
                current = node.right;
            } else {
                // Both subtrees completed
                if (node.left == null && node.right == null
                        && sum == targetSum) {
                    result.add(new ArrayList<>(path));
                }

                stack.pop();
                path.remove(path.size() - 1);
                sum -= node.val;
                lastVisited = node;
            }
        }

        return result;
    }
}
