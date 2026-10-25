
class Frame {
    TreeNode node;
    int remainingSum;
    List<Integer> path;

    Frame(TreeNode node, int remainingSum, List<Integer> path) {
        this.node = node;
        this.remainingSum = remainingSum;
        this.path = path;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Frame> stack = new Stack<>();

        stack.push(new Frame(
            root,
            targetSum - root.val,
            new ArrayList<>(List.of(root.val))
        ));

        while (!stack.isEmpty()) {
            Frame frame = stack.pop();

            TreeNode node = frame.node;
            int remaining = frame.remainingSum;

            // Only root-to-leaf paths count
            if (node.left == null && node.right == null) {
                if (remaining == 0) {
                    result.add(frame.path);
                }
                continue;
            }

            if (node.right != null) {
                List<Integer> path = new ArrayList<>(frame.path);
                path.add(node.right.val);

                stack.push(new Frame(
                    node.right,
                    remaining - node.right.val,
                    path
                ));
            }

            if (node.left != null) {
                List<Integer> path = new ArrayList<>(frame.path);
                path.add(node.left.val);

                stack.push(new Frame(
                    node.left,
                    remaining - node.left.val,
                    path
                ));
            }
        }

        return result;
    }
}
