// marked for revisit need to learn union find 
class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 1; i < edges.length + 1; i++) {
            parent[i] = i;
        }
        this.parent = parent;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[] { -1, -1 };
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY)
            return false;
        if (parentX > parentY) {
            parent[parentX] = parentY;
        }else{
            parent[parentY] = parentX;
        }
        return true;
    }
}
