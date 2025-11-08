/* 
1. We can use a Dfs from an o and we explore all the node other connected O 
2. When we hit a boundary we can say that the path is cannot be changed to X
3. We also need to have a visited array as we dont what to visit the paths that we already visited
4. Now after all the computation we get all the nodes that can be changed to X 
5. This way we can make the time complexity m X n 

 */
class Solution {
    List<int[]> ans;
    boolean[][] visited;
    char[][] board;
    boolean hitBoundary;

    public void solve(char[][] board) {
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                List<int[]> current = new ArrayList<>();
                this.hitBoundary = false;
                if (board[i][j] == 'O' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, current, hitBoundary);
                }
                if (!hitBoundary) {
                    for (int[] node : current) {
                        int idx = node[0];
                        int jdx = node[1];
                        board[idx][jdx] = 'X';
                    }
                }
                current.clear();
            }
        }

    }

    public void dfs(int i, int j, List<int[]> current, boolean hitBoundary) {
        int m = board.length;
        int n = board[0].length;
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            this.hitBoundary = true;
        }
        current.add(new int[] { i, j });

        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n
                    && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                dfs(newRow, newCol, current, hitBoundary);

            }
        }

    }
}