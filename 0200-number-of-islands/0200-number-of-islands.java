class Solution {
    boolean visited[][] ;
    public int numIslands(char[][] grid) {
        this.visited = new boolean[grid.length][ grid[0].length ];
        int count = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfsGraph(grid, i, j);
                    count++;    
                }
            }
        }
        
                                
    return count; 
    }
    public void bfsGraph(char [][] grid, int i , int j){
        Queue<int []> queue = new LinkedList<>();
        int [] node  = new int[] {i, j};
        queue.add(node);
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            node  = queue.poll();
            i = node[0];
            j = node[1];

            if(i + 1 < grid.length && grid[i + 1][j] == '1' ){
                queue.add(new int[] {i + 1, j});
                 grid[i + 1][j] = '0';
                
            }
            if(i - 1 >= 0  && grid[i - 1][j] == '1' ){
                queue.add(new int[] {i - 1, j});
                 grid[i - 1][j] = '0';
                
            }
            if(j + 1 < grid[0].length && grid[i][j + 1] == '1' ){
                queue.add(new int[] {i, j + 1 });
                 grid[i][j + 1] = '0';
                
            }
            if( j - 1 >= 0  && grid[i][j - 1] == '1' ){
                queue.add(new int[] {i, j - 1 });
                 grid[i][j - 1] = '0';
                
            }


            
        }
    }

}