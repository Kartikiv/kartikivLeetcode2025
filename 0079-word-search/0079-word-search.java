class Frame {
    int i;
    int j;
    int direction;

    public Frame(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    private static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, board, word, visited))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;
        Stack<Frame> stack = new Stack<>();
        stack.add(new Frame(i, j));
        visited[i][j] = true;
        while (!stack.isEmpty()) {
            Frame frame = stack.peek();
            if (stack.size() == word.length()) {
                return true;
            }

            if (frame.direction == 4) {
                stack.pop();
                visited[frame.i][frame.j] = false;
                continue;
            }
            int newI = frame.i + directions[frame.direction][0];
            int newJ = frame.j + directions[frame.direction++][1];
            if (newI < 0 || newJ < 0) {
                continue;
            }
            if (newI >= n || newJ >= m) {
                continue;
            }
            if (visited[newI][newJ]) {
                continue;
            }
            if (board[newI][newJ] != word.charAt(stack.size())) {
                continue;
            }
            stack.add(new Frame(newI, newJ));
            visited[newI][newJ] = true;

        }
        return false;

    }
}