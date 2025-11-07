class Solution {
    public int orangesRotting(int[][] rooms) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int fresh = checkBoard(rooms);
        if(queue.isEmpty()){ return fresh > 0 ? -1: 0;}
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                int[] node = queue.poll();
                for (int[] dir : directions) {

                    int i = node[0] + dir[0];
                    int j = node[1] + dir[1];
                    if (j < rooms[0].length && i < rooms.length && j >= 0 && i >= 0) {
                        if (rooms[i][j] == 1) {
                            rooms[i][j] = 2;
                            queue.offer(new int[] { i, j });
                            fresh--;
                        }
                    }

                }

            }
            count++;

        }

        return (fresh == 0) ? count - 1 : -1;
    }

    public int checkBoard(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int i : row) {
                if (i == 1) {
                    count ++;
                }
            }
        }

        return count;
    }

}