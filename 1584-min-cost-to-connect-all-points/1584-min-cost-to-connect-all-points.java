

// Edge between two points (by index) with a cost (distance)
class GraphNode {
    int u;          // index of first point
    int v;          // index of second point
    int distance;   // cost to connect them

    public GraphNode(int u, int v, int[][] points) {
        this.u = u;
        this.v = v;
        this.distance = getDistance(points[u], points[v]);
    }

    // Manhattan distance for this problem
    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

// Union-Find (Disjoint Set Union) with path compression + union by rank
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // returns true if union actually merged two different sets
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;

        // Build all edges between pairs of points
        PriorityQueue<GraphNode> pQueue = buildGraphNodes(points);

        DSU dsu = new DSU(n);
        int edgesUsed = 0;
        int totalCost = 0;

        // Kruskal's algorithm:
        // Keep taking the smallest edge that connects two different components
        while (!pQueue.isEmpty() && edgesUsed < n - 1) {
            GraphNode edge = pQueue.poll();
            if (dsu.union(edge.u, edge.v)) {
                totalCost += edge.distance;
                edgesUsed++;
            }
        }

        return totalCost;
    }

    // Build all edges (i, j) with their distances and push them into a min-heap
    public PriorityQueue<GraphNode> buildGraphNodes(int[][] points) {
        int n = points.length;
        PriorityQueue<GraphNode> pQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.distance, b.distance)
        );

        // Only need i < j to avoid duplicates
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pQueue.add(new GraphNode(i, j, points));
            }
        }

        return pQueue;
    }
}
