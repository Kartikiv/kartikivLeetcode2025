class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int ans = helperDfs(obstacleGrid, 0, 0);
        return -ans;
    }

    public int helperDfs(int[][] obstacleGrid, int i, int j) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (i >= m || j >= n) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (obstacleGrid[i][j] < 0) {
            return obstacleGrid[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return -1;
        }

        obstacleGrid[i][j] =
            helperDfs(obstacleGrid, i + 1, j) +
            helperDfs(obstacleGrid, i, j + 1);

        return obstacleGrid[i][j];
    }
}