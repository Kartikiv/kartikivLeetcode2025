import java.util.*;

class Frame {
    int i, j;
    int direction = 0;

    Frame(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    private static final int[][] directions = {
        {1, 0}, {0, 1}, {0, -1}, {-1, 0}
    };

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        if (board.length == 0 || board[0].length == 0)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j,
                        char[][] board, String word) {

        if (board[i][j] != word.charAt(0))
            return false;

        boolean[][] visited =
            new boolean[board.length][board[0].length];

        Deque<Frame> stack = new ArrayDeque<>();

        stack.push(new Frame(i, j));
        visited[i][j] = true;

        while (!stack.isEmpty()) {

            Frame current = stack.peek();

            // Depth of stack = characters matched
            int index = stack.size() - 1;

            if (index == word.length() - 1)
                return true;

            // All directions explored: BACKTRACK
            if (current.direction == 4) {
                visited[current.i][current.j] = false;
                stack.pop();
                continue;
            }

            // Explore exactly ONE direction
            int[] d = directions[current.direction++];

            int ni = current.i + d[0];
            int nj = current.j + d[1];

            if (ni < 0 || nj < 0 ||
                ni >= board.length ||
                nj >= board[0].length)
                continue;

            if (visited[ni][nj])
                continue;

            if (board[ni][nj] != word.charAt(index + 1))
                continue;

            visited[ni][nj] = true;
            stack.push(new Frame(ni, nj));
        }

        return false;
    }
}