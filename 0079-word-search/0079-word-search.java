class Solution {
    public boolean exist(char[][] board, String word) {
       for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){ 
           if (dfs(i, j, board, word, 0)){
            return true;
           }
        }
       } 
    return false;
    }
    public boolean dfs(int i, int j,char[][] board, String word, int index){ 
       
        if(index == word.length()){ 
            return true;
        }
        
         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) != board[i][j]){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
       boolean left =  dfs(i + 1, j,board, word, index + 1);
       boolean right =  dfs(i - 1, j,board, word, index + 1);
        boolean top = dfs(i, j + 1,board, word, index + 1);
        boolean bottom = dfs(i, j - 1,board, word, index + 1);
      
        board[i][j] = temp;

    return top || bottom || left || right; 
    }
}