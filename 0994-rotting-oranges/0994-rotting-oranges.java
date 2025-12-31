class Cell{
    int i,j;
    public Cell(int i , int j ){
        this.i = i;
        this.j = j; 
    }
}
class Solution {
    public int orangesRotting(int[][] rooms) {
        if(rooms.length == 1 && rooms[0].length == 1 && rooms[0][0] == 1 ) return -1;
        int count = 0 ;
        Queue<Cell> queue = new LinkedList<Cell>();
        for (int i = 0 ; i < rooms.length; i++){
            for(int j =0; j < rooms[0].length; j++){
                if(rooms[i][j] == 2){
                    queue.add(new Cell(i, j));
                }
            }
        } 
        boolean flag = true;
        for (int i = 0 ; i < rooms.length; i++){
            for(int j =0; j < rooms[0].length; j++){
                if(rooms[i][j] == 1){
                    flag = false;
                }
            }
        }
        if(queue.isEmpty() && flag ) return 0 ;
        if(queue.isEmpty() && !flag ) return -1 ;
        return bfs(rooms, queue); 
        }
    public int bfs(int [][] rooms, Queue<Cell> queue){
        int[][] directions = {{ -1, 0 }, { 1, 0 }, { 0, -1 } ,{ 0, 1 }};
        int count = 0 ;
        while(!queue.isEmpty()){
            int size = queue.size();
            count ++;
            for(int i =0 ; i < size; i++){
            Cell cell = queue.poll();
           for (int [] direction : directions){
            int newI = cell.i + direction[0];
            int newJ = cell.j + direction[1];
            if(newI >= 0 && newI < rooms.length && newJ >= 0 && newJ < rooms[0].length && rooms[newI][newJ] == 1){
                rooms[newI][newJ] = 2;
                queue.add(new Cell(newI, newJ));
            }
           } 
            }
        }    
        boolean flag = true;
        for (int i = 0 ; i < rooms.length; i++){
            for(int j =0; j < rooms[0].length; j++){
                if(rooms[i][j] == 1){
                    flag = false;
                }
            }
        }
    return flag ? count - 1 : -1 ;
    }
}