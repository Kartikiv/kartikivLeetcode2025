
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;
        long sum = 0;

        while (curr != null || !stack.isEmpty()) {

            // Traverse left
            while (curr != null) {
                stack.push(curr);
                path.add(curr.val);
                sum += curr.val;
                curr = curr.left;
            }

            TreeNode node = stack.peek();

            // Explore right subtree if not visited
            if (node.right != null && node.right != lastVisited) {
                curr = node.right;
                continue;
            }

            // Both subtrees are processed
            if (node.left == null && node.right == null
                    && sum == targetSum) {
                result.add(new ArrayList<>(path));
            }

            // Backtrack
            stack.pop();
            path.remove(path.size() - 1);
            sum -= node.val;
            lastVisited = node;
        }

        return result;
    }
}
