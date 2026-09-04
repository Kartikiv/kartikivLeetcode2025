class Solution {
    List<List<String>> ans;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.ans = new ArrayList<>();
        this.n = n;
        dfs(n - 1, new boolean[n], new boolean[2*n], new boolean[2 * n], new boolean[n][n]);
        
    return ans;
    }
    public void dfs(int r, boolean[] col, boolean[] diagnol, boolean [] antiDiagnol, boolean[][] board){ 
        if(r == -1){ 
            ans.add(buildAns(board));
            board = new boolean[n][n];
            return;
        }
        for(int i = 0; i < n ; i++){ 
            // check if we can place a queen in the row, col and diag and anti diag
            if(!col[i] && !diagnol[r + i] && !antiDiagnol[i - r + n - 1]){
                
                col[i] = true; 
                diagnol[r + i] = true;
                antiDiagnol[i - r + n - 1] = true;
                board[r][i] = true;
                dfs(r - 1, col, diagnol, antiDiagnol, board);
                col[i] = false; 
                diagnol[r + i] = false;
                antiDiagnol[i - r + n - 1] = false;
                board[r][i] = false;
            }

        }
    }
    public List<String> buildAns(boolean[][] board){ 
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++){ 
            sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){ 
                if(board[i][j]){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
        }
    return ans;
    }

}