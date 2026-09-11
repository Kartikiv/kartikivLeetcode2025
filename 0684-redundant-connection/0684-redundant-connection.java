class Solution {
    int[] ans;

    public int[] findRedundantConnection(int[][] edges) {
        // Union Find to detect cycles
        this.ans = new int[2];
        int numNodes = edges.length;
        int[] parent = new int[numNodes + 1];
        for (int i = 0; i < numNodes; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            merge(a, b, parent);
        }

        return ans;
    }

    public int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    public void merge(int a, int b, int[] parent) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) {
            ans = new int[] { a, b };
            return;
        }
        parent[rootB] = rootA;
    }
}
