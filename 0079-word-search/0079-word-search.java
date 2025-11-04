class Solution {
    char[][] board;
    String word;
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        StringBuilder current = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                helper(i, j, current, visited,0);
                }
            }
        }
        return flag;
    }

    public void helper(int i, int j, StringBuilder current, boolean visited[][], int index) {
        if (flag || i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
          if (board[i][j] != word.charAt(index)) {
            return;
        }

        current.append(board[i][j]);
        if (current.toString().equals(word)) {
            flag = true;
            return;
        }
        visited[i][j] = true;
        helper(i + 1, j, current, visited,index + 1);
        helper(i, j - 1, current, visited, index + 1);

        helper(i - 1, j, current, visited, index + 1);
        helper(i, j + 1, current, visited, index + 1);

        visited[i][j] = false;
        current.deleteCharAt(current.length() - 1);

    }
}