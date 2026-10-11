class Solution {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] labels = new int[rows][cols];

        // Maximum possible number of islands = rows * cols
        int[] parent = new int[rows * cols + 1];

        int nextIslandId = 1;
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '0') {
                    continue;
                }

                int top = 0;
                int left = 0;

                if (i > 0 && labels[i - 1][j] != 0) {
                    top = find(labels[i - 1][j], parent);
                }

                if (j > 0 && labels[i][j - 1] != 0) {
                    left = find(labels[i][j - 1], parent);
                }

                // No existing island around us
                if (top == 0 && left == 0) {

                    int id = nextIslandId++;

                    labels[i][j] = id;
                    parent[id] = id;

                    islandCount++;
                }

                // Only left
                else if (top == 0) {
                    labels[i][j] = left;
                }

                // Only top
                else if (left == 0) {
                    labels[i][j] = top;
                }

                // Both belong to same component
                else if (top == left) {
                    labels[i][j] = top;
                }

                // Two previously separate islands are connected
                else {
                    int rootTop = find(top, parent);
                    int rootLeft = find(left, parent);

                    if (rootTop != rootLeft) {
                        parent[rootLeft] = rootTop;
                        islandCount--;
                    }

                    labels[i][j] = rootTop;
                }
            }
        }

        return islandCount;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}