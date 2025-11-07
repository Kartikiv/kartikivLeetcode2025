class Solution {
    int heights[][];

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        this.heights = heights;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfsWaterPath(0, j, pacific);
            dfsWaterPath(m - 1, j, atlantic);
        }
        for (int i = 0; i < m; i++) {
            dfsWaterPath(i, 0, pacific);
            dfsWaterPath(i, n - 1, atlantic);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));

                }
            }
        }

        return ans;
    }

    public void dfsWaterPath(int i, int j, boolean[][] reached) {
        if (reached[i][j])
            return;
        reached[i][j] = true;

        int[][] direction = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = heights.length;
        int n = heights[0].length;
        for (int[] dir : direction) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[i][j]) {
                dfsWaterPath(newRow, newCol, reached);

            }

        }

    }
}