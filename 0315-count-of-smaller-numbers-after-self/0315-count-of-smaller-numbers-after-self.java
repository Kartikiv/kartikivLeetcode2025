class Solution {
    static class Node {
        int val, priority;
        int count = 1;
        int size = 1;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.priority = ThreadLocalRandom.current().nextInt();
        }
    }

    Node root;

    int size(Node n) {
        return n == null ? 0 : n.size;
    }

    void update(Node n) {
        if (n != null) {
            n.size = size(n.left) + size(n.right) + n.count;
        }
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;

        update(y);
        update(x);
        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;

        update(x);
        update(y);
        return y;
    }

    Node insert(Node node, int val) {
        if (node == null) return new Node(val);

        if (val < node.val) {
            node.left = insert(node.left, val);

            if (node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        } else if (val > node.val) {
            node.right = insert(node.right, val);

            if (node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        } else {
            node.count++;
        }

        update(node);
        return node;
    }

    int countLess(Node node, int val) {
        int result = 0;

        while (node != null) {
            if (val <= node.val) {
                node = node.left;
            } else {
                result += size(node.left) + node.count;
                node = node.right;
            }
        }

        return result;
    }

    public List<Integer> countSmaller(int[] nums) {
        root = null;
        Integer[] ans = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = countLess(root, nums[i]);
            root = insert(root, nums[i]);
        }

        return Arrays.asList(ans);
    }
}