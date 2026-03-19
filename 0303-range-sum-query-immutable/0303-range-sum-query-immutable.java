class SegmentTree {
    int[] tree;
    int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[4 * arr.length];
        build(1, 0, arr.length - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public int query(int node, int start, int end, int left, int right) {
        // no overlap
        if (end < left || start > right) {
            return 0;
        }

        // complete overlap
        if (left <= start && end <= right) {
            return tree[node];
        }

        // partial overlap
        int mid = start + (end - start) / 2;

        int leftSum = query(2 * node, start, mid, left, right);
        int rightSum = query(2 * node + 1, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}

class NumArray {
    SegmentTree segmentTree;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.segmentTree = new SegmentTree(nums);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(1, 0, nums.length - 1, left, right);
    }
}