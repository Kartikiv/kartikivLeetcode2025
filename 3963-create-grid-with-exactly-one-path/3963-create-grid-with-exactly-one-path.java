class Solution {
    private static int[][] directions = new int[][] { { 0, -1 }, { -1, 0 } };

    public String[] createGrid(int m, int n) {
        // from every cell there should only be on option to reach 
        boolean[][] visited = new boolean[m][n];
        String[][] grid = new String[m][n];
        int[] start = new int[] { m - 1, n - 1 };
        grid[m - 1][n - 1] = ".";
        visited[m - 1][n - 1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int[][] children = new int[2][2];
            int i = 0;
            for (int[] direction : directions) {
                if (direction[0] + node[0] >= m || direction[0] + node[0] < 0) {
                    continue;
                }
                if (direction[1] + node[1] >= n || direction[1] + node[1] < 0) {
                    continue;
                }
                if (visited[direction[0] + node[0]][direction[1] + node[1]]) {
                    continue;
                }
                children[i++] = new int[] { direction[0] + node[0], direction[1] + node[1] };
                visited[direction[0] + node[0]][direction[1] + node[1]] = true;
            }
            // one valid child
            if (i == 2) {
                grid[children[1][0]][children[1][1]] = "#";
            }
            if (i != 0) {
                grid[children[0][0]][children[0][1]] = ".";
                queue.add(children[0]);
            }
        }
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            String[] row = grid[i];
            StringBuilder sb = new StringBuilder();
            for (String s : row) {
                if (s == null || s.isBlank()) {
                    sb.append("#");
                } else {
                    sb.append(s);
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }
}