/* 
1. We can use a Dfs from an o and we explore all the node other connected O 
2. When we hit a boundary we can say that the path is cannot be changed to X
3. We also need to have a visited array as we dont what to visit the paths that we already visited
4. Now after all the computation we get all the nodes that can be changed to X 
5. This way we can make the time complexity m X n 

 */

record Pair(int i, int j) {
}

class Solution {
    boolean[][] visited;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        this.visited = new boolean[m][n];
        Set<Pair> current = new HashSet<>();
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                current.add(new Pair(i, 0));
                visited[i][0] = true;
                dfs(i, 0, current);

            }
            if (board[i][n - 1] == 'O') {
                current.add(new Pair(i, n - 1));
                visited[i][n - 1] = true;
                dfs(i, n - 1, current);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                current.add(new Pair(0, j));
                visited[0][j] = true;
                dfs(0, j, current);
            }
            if (board[m - 1][j] == 'O') {
                current.add(new Pair(m - 1, j));
                visited[m - 1][j] = true;
                dfs(m - 1, j, current);
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!current.contains(new Pair(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println(current);

    }

    public void dfs(int i, int j, Set<Pair> current) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n
                    && !visited[newRow][newCol] && board[newRow][newCol] == 'O') {
                current.add(new Pair(newRow, newCol));
                visited[newRow][newCol] = true;
                dfs(newRow, newCol, current);
            }
        }

    }

    /* 
    Optimization Plan : 
    1. In this process we are starting from the innernode and doing bfs
    2. In an other way we can use the fact that all the nodes which connect the outerbounderies
    cannot be made 'X'
    3. There we can start from the outside and mark all the non flipable node, then after all the  boundary nodes checked then flip the remain flipable nodes.
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
     */

}