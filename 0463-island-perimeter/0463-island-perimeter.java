class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    ans += getPerimeter(grid, i , j);
                }
            }
        }
    return ans; 
    }
    public int getPerimeter(int [][] grid, int i, int j){
        int ans = 0;
        
        if(i + 1 >= grid.length || grid[i + 1][j] == 0 ){
            ans += 1;
        }
        if(j + 1 >= grid[0].length || grid[i][j + 1] == 0 ){
            ans += 1;
        }
        if(i - 1 < 0 || grid[i - 1][j] == 0 ){
            ans += 1;
        }
        if(j - 1 < 0 || grid[i][j - 1] == 0 ){
            ans += 1;
        }
    return ans;
    }
}