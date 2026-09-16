class Solution {

    int rows, cols;
    int[] rowQueue;
    int[] colQueue;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int capacity = rows * cols;

        rowQueue = new int[capacity];
        colQueue = new int[capacity];

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            char[] row = grid[r];

            for (int c = 0; c < cols; c++) {

                if (row[c] == '1') {
                    flood(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void flood(char[][] grid, int startRow, int startCol) {

        int head = 0;
        int tail = 0;

        rowQueue[tail] = startRow;
        colQueue[tail++] = startCol;

        while (head < tail) {

            int r = rowQueue[head];
            int c = colQueue[head++];

            if (grid[r][c] != '1')
                continue;

            char[] current = grid[r];

            int left = c;
            int right = c;

            while (left > 0 && current[left - 1] == '1')
                left--;

            while (right + 1 < cols && current[right + 1] == '1')
                right++;

            for (int x = left; x <= right; x++)
                current[x] = '0';

            if (r > 0)
                tail = scanRow(grid, r - 1, left, right, tail);

            if (r + 1 < rows)
                tail = scanRow(grid, r + 1, left, right, tail);
        }
    }

    private int scanRow(
        char[][] grid,
        int r,
        int left,
        int right,
        int tail
    ) {

        char[] row = grid[r];

        int c = left;

        while (c <= right) {

            if (row[c] == '1') {

                // enqueue only once for this contiguous run
                rowQueue[tail] = r;
                colQueue[tail++] = c;

                while (c <= right && row[c] == '1')
                    c++;

            } else {
                c++;
            }
        }

        return tail;
    }
}