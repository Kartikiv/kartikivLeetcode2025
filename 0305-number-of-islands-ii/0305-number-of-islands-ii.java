class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        DSU dsu = new DSU(m, n);

        int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
        };

        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];

            int x = row * n + col;

            // duplicate land addition
            if (dsu.isLand(x)) {
                ans.add(dsu.islands);
                continue;
            }

            // new isolated island
            dsu.addLand(x);

            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int neighbor = nr * n + nc;

                if (dsu.isLand(neighbor)) {
                    dsu.union(x, neighbor);
                }
            }

            ans.add(dsu.islands);
        }

        return ans;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    int islands;

    public DSU(int m, int n) {
        parent = new int[m * n];
        rank = new int[m * n];

        // -1 means water / inactive
        Arrays.fill(parent, -1);
    }

    public boolean isLand(int x) {
        return parent[x] != -1;
    }

    public void addLand(int x) {
        parent[x] = x;
        islands++;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        islands--;
    }
}