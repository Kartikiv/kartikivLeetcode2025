class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, bfsGraph(grid, i, j));
                }
            }
        }
    return max; }

    public int bfsGraph(int[][] grid, int i , int j){
        int count = 0; 
        Queue<int[]> queue  = new LinkedList<>();
        queue.add(new int [] {i, j});
        grid[i][j] = 0;
        while(!queue.isEmpty()){
            int [] node = queue.poll();
            i = node[0];
            j = node[1];
            
            count++;

            if(i + 1 < grid.length && grid[i + 1][j] == 1){
                queue.add(new int [] {i + 1, j});
                grid[i + 1][j] = 0;
            }
            if(j + 1 < grid[0].length && grid[i][j + 1] == 1){
                queue.add(new int [] {i, j + 1});
                 grid[i][j + 1] = 0;
            }
            if(j > 0 && grid[i][j - 1] == 1){
                queue.add(new int[] {i , j - 1});
                 grid[i][j - 1] = 0;
            }
            if(i > 0 && grid[i - 1][j] == 1){
                queue.add(new int[] {i - 1, j});
                 grid[i - 1][j] = 0;
            }

            
        } 


    return count; 
    }
}