import java.util.LinkedList;
import java.util.Queue;

class Solution {
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
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i, j));
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
            for (int[] direction : directions) {
                int newI = node.getKey() + direction[0];
                int newJ = node.getValue() + direction[1];
                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == '1') {
                    queue.add(new Pair<>(newI, newJ));
                    grid[newI][newJ] = '0';
                }
            }
        }
    }
}