class Node{ 
    int i ; 
    int j ; 
    public Node(int i, int j){ 
        this.i = i; 
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0 ;
        int m = grid.length; 
        int n = grid[0].length;
        for(int i =0 ; i < m ; i++){ 
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1') {
                    bfs(grid, new Node(i, j));
                    count++;
                }
            }
        }

   return count; 
    }
    public void bfs(char[][] grid, Node root){ 
        int m = grid.length; 
        int n = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); 
        grid[root.i][root.j] = '0';
        int [][] directions = new int [][]{{0,1} , {1,0}, {0, -1}, {-1,0}};
        while(!queue.isEmpty()){ 
            Node node = queue.poll();
            int i = node.i; 
            int j = node.j;
            // insert valid children 
            for(int [] direction : directions){ 
                int newi = i + direction[0];
                int newj = j + direction[1];
                if(newi >= 0 && newj >= 0 
                    && newi < m && newj < n 
                    && grid[newi][newj] == '1'
                ){ 
                   // mark visited
                    grid[newi][newj] = '0';
                    queue.add(new Node(newi , newj));
                }
            }


            
        }

    }
    
}
