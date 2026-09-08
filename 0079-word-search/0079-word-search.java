class Solution {
    boolean ans;

    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, 0, i, j, word)) {
                    return true;
                }
            }
        }
        return ans;
    }

    public boolean dfs(char[][] board, int index, int i, int j, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found =
                dfs(board, index + 1, i + 1, j, word) ||
                dfs(board, index + 1, i - 1, j, word) ||
                dfs(board, index + 1, i, j + 1, word) ||
                dfs(board, index + 1, i, j - 1, word);
        // back tracking and marking the steps as we visit here we can also maintain a visited bool array 
        // but the consequences are extra memory consumption. 
        board[i][j] = temp;

        return found;
    }

}