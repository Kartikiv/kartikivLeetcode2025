import java.util.*;

class NumMatrix {
    HashMap<Pair<Integer,Integer> , Integer> map; 
    int [][] matrix;
    public NumMatrix(int[][] matrix) {
        this.map = new HashMap<>();
        this.matrix = matrix;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                map.put(new Pair<>(i, j), sum);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans  = 0 ;
        for (int i = row1; i <=row2; i++) {
            Pair<Integer,Integer> left = col1 - 1 < 0 ? new Pair<>(i - 1, matrix[0].length - 1 ) : new Pair<>(i, col1 - 1);
            ans +=map.get(new Pair<>(i,col2)) - map.getOrDefault(left, 0);
        }
        return ans ; 
    }


}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */