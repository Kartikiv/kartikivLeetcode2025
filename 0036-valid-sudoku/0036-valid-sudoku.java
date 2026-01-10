// So the coditions are every row should have unique every column should have unique
// and every 3 * 3 grid should be unique 

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> [] rowSet = new HashSet[board.length];
        HashSet<Character> [] colSet = new HashSet[board[0].length];

        for (int i = 0; i < board.length; i++) {
            rowSet[i] = new HashSet<>();
        }

        for (int j = 0; j < board[0].length; j++) {
            colSet[j] = new HashSet<>();
        }


        for (int i = 0 ; i < board.length; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                char c = board[i][j];
                if(c != '.'){
                if(!rowSet[i].add(c)) return false;
                if(!colSet[j].add(c)) return false;

                }
            }
        }



    return checkBox(board);
    }

    public boolean checkBox(char [][] board){
        int row = 3;
        int col = 3;

        HashSet <Character> box;

        for(int i = 0; i < board.length; i = i + row){
            for(int j = 0; j < board[0].length; j = j + col){
                box =  new HashSet<>();

                 for (int k = i ; k < i + row; k++){
            for (int l = j ; l < j + col ; l++){
                char c = board[k][l];

                if(c != '.'){
                if(!box.add(c)) return false;
                }

            }
        }
    
    }
}
    return true;
    }
}