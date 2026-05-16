class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1)
            return obstacleGrid[0][0] == 1 ? 0 : 1;
        helperDfs(obstacleGrid, 0, 0);
        return -1 * obstacleGrid[0][0];
    }

    public int helperDfs(int[][] obstacleGrid, int i, int j) {

        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return obstacleGrid[i][j] == 1 ? 0 : -1;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (obstacleGrid[i][j] < 0) {
            return obstacleGrid[i][j];
        }
        obstacleGrid[i][j] = helperDfs(obstacleGrid, i + 1, j) + helperDfs(obstacleGrid, i, j + 1);

        return obstacleGrid[i][j];

    }
}