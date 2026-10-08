class Solution {
    private static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){ 
            for(int j = 0; j < grid[0].length; j++){ 
                // Add all the rotten oranges to the queue
                if(grid[i][j] == 2){ 
                    queue.add(new int [] {i, j});
                }else if(grid[i][j] == 1){ 
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){ 
            return 0; 
        }
        int timeTaken = 0; 
        while(!queue.isEmpty()){ 
            int size = queue.size();
            
            for(int i = 0; i < size; i++){ 
                int [] node = queue.poll();
                for(int [] direction : directions){ 
                    int newI = node[0] + direction[0]; 
                    int newJ = node[1] + direction[1];
                    if(newI >= 0 && newJ >= 0 && 
                    newI < grid.length && newJ < grid[0].length &&
                    grid[newI][newJ] == 1){ 
                        queue.add(new int[] {newI, newJ});
                        freshOranges--;
                        grid[newI][newJ] = 2; // turn fresh oranges to rotten oranges
                    }
                }
            }
            timeTaken++;
        }
        return freshOranges == 0 ? timeTaken - 1 : -1;
    }
}