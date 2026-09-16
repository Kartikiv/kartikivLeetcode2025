class Solution {

    int rows;
    int cols;

    int[] rowQueue;
    int[] colQueue;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int capacity = rows * cols;

        rowQueue = new int[capacity];
        colQueue = new int[capacity];

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            char[] currentRow = grid[row];

            for (int col = 0; col < cols; col++) {

                if (currentRow[col] == '1') {
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

        rowQueue[tail] = startRow;
        colQueue[tail++] = startCol;

        grid[startRow][startCol] = '0';

        while (head < tail) {

            int row = rowQueue[head];
            int col = colQueue[head++];

            // DOWN
            if (row + 1 < rows && grid[row + 1][col] == '1') {

                grid[row + 1][col] = '0';

                rowQueue[tail] = row + 1;
                colQueue[tail++] = col;
            }

            // UP
            if (row > 0 && grid[row - 1][col] == '1') {

                grid[row - 1][col] = '0';

                rowQueue[tail] = row - 1;
                colQueue[tail++] = col;
            }

            // RIGHT
            if (col + 1 < cols && grid[row][col + 1] == '1') {

                grid[row][col + 1] = '0';

                rowQueue[tail] = row;
                colQueue[tail++] = col + 1;
            }

            // LEFT
            if (col > 0 && grid[row][col - 1] == '1') {

                grid[row][col - 1] = '0';

                rowQueue[tail] = row;
                colQueue[tail++] = col - 1;
            }
        }
    }
}