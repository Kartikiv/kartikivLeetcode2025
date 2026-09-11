class Solution {
    public int findCircleNum(int[][] isConnected) {
        // We are given an n * n matrix so there a n numCities
        int numCities = isConnected.length;
        int[] parent = new int[numCities];
        for (int i = 0; i < numCities; i++) {
            // make all the cities there own parent
            parent[i] = i;
        }
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (isConnected[i][j] == 1 && i != j) { // there is connection between diffrent cities
                    // union if a connection is present
                    union(i, j, parent);
                }
            }
        }
        int connectedProvinces = 0;
        // int the end after everthing check the parents
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                connectedProvinces++;
            }
        }
        return connectedProvinces;
    }

    public int find(int node, int[] parent) {
        // If node is its own parent, we found the root
        if (parent[node] == node) {
            return node;
        }

        // Find root + path compression
        parent[node] = find(parent[node], parent);

        return parent[node];
    }

    public void union(int a, int b, int[] parent) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        // Already belong to same province
        if (rootA == rootB) {
            return;
        }

        // Merge the two provinces
        parent[rootB] = rootA;
    }
}
