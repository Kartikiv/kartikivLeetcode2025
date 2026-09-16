import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    public int numIslands(char[][] grid) {
        int numIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    numIsland++;
                }
            }
        }
        return numIsland;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue =new ArrayDeque<>();
        queue.add(new int[]{i,j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] direction : directions) {
                int newI = node[0] + direction[0];
                int newJ = node[1] + direction[1];
                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == '1') {
                    queue.add(new int []{newI, newJ});
                    grid[newI][newJ] = '0';
                }
            }
        }
    }
}