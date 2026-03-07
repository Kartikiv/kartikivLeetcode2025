import java.util.LinkedList;
import java.util.Queue;
class Node{
    int i;
    int j;
    public Node(int i , int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(bfs(grid, i,j), maxArea);
                }
            }
        }

        return maxArea;
    }
    int bfs(int [][] grid, int i , int j){
        int area = 0;
        int [][] directions = new int [][] {{-1,0}, {0, -1}, {1,0}, {0,1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i,j));
        grid[i][j] =0 ;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            area++;
            for(int [] direction : directions){
                int newi = node.i + direction[0];
                int newj = node.j + direction[1];
                if(newi >= 0 && newi < grid.length && newj >= 0 &&
                        newj < grid[0].length && grid[newi][newj] == 1){
                    queue.add(new Node(newi, newj));
                    grid[newi][newj] = 0;
                }
            }
        }
        return area;
    }
}