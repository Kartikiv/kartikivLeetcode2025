import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }

            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length
                    && grid[newI][newJ] == '1') {

                dfs(grid, newI, newJ);
            }
        }
    }
}
