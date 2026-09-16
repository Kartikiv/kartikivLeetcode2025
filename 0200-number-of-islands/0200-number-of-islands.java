class Solution {

    static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    int rows;
    int cols;
    int[] queue;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        // Allocate once and reuse for every island
        queue = new int[rows * cols];

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == '1') {
                    bfs(grid, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int startRow, int startCol) {

        int head = 0;
        int tail = 0;

        // Encode row/col into one int
        queue[tail++] = startRow * cols + startCol;
        grid[startRow][startCol] = '0';

        while (head < tail) {

            int position = queue[head++];

            int row = position / cols;
            int col = position % cols;

            for (int[] direction : DIRECTIONS) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (
                    newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    grid[newRow][newCol] == '1'
                ) {

                    grid[newRow][newCol] = '0';

                    queue[tail++] = newRow * cols + newCol;
                }
            }
        }
    }
}