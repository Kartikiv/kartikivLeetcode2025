class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
       dfs(image, sr, sc, color,image[sr][sc]); 
return image;
    }
    public void dfs(int [][] image, int i, int j, int color, int target){ 
      
        image[i][j] = color;
        int [][] directions = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        for (int[] direction : directions) {
            int newi = i + direction[0]; 
            int newj = j + direction[1];
            if(newi >= 0 && newi < image.length && newj >= 0 && newj < image[0].length && image[newi][newj] == target){
                dfs(image, newi, newj, color,target);
            }
        }
    }
}