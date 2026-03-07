import java.util.LinkedList;
import java.util.Queue;
class Node {
    int i ;
    int j ;
    public Node(int i , int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
    for(int i = 0 ; i < grid.length ; i++){
        for (int j = 0 ; j < grid[0].length ; j++){
            if (grid[i][j] == '1'){
                bfs(grid, i ,j);
                count++;
            }
        }
    }
   return count;
    }
    void bfs(char[][] grid, int i , int j){
        int [][] directions = new int [][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i,j));
        grid[i][j] = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int [] direction : directions){
                int newi = node.i + direction[0];
                int newj = node.j + direction[1];
                if(newi >= 0 && newi < grid.length 
                    && newj >= 0 && newj <grid[0].length 
                    && grid[newi][newj] == '1'){
                    queue.add(new Node(newi, newj));
                    grid[newi][newj] = 0 ;
                }

            }
        }

    }
}