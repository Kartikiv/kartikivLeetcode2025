class Solution {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(m - 1, n - 1);
    }

    public int dfs(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] != -1)
            return memo[m][n];
        if (m == 0 && n == 0) {
            return 1;
        }
        int ans = dfs(m - 1, n) + dfs(m, n - 1);
        memo[m][n] = ans;
        return ans;
    }
}