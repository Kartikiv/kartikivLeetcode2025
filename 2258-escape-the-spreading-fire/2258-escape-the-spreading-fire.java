class Solution {
    public int maximumMinutes(int[][] grid) {
        // multi part bfs 
        // insert all the are fire and then the person 

        Queue<Pair<Integer, Integer>> queueFire = new LinkedList<>();
        int stepCount = 1;
        if (grid[0][0] == 1 || grid[0][0] == 2)
            return -1;
        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { -1, 0 },
                { 0, -1 }
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queueFire.add(new Pair(i, j));
                }
            }
        }

        while (!queueFire.isEmpty()) {
            // fire spread then person enters
            int fireQueueSize = queueFire.size();
            for (int i = 0; i < fireQueueSize; i++) {
                Pair<Integer, Integer> firePosition = queueFire.poll();
                for (int[] direction : directions) {
                    int row = firePosition.getKey();
                    int col = firePosition.getValue();
                    row += direction[0];
                    col += direction[1];
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) {
                        if (grid[row][col] != 1 && grid[row][col] != 2 && grid[row][col] >= 0) {
                            grid[row][col] = -1 * stepCount;
                            queueFire.add(new Pair(row, col));
                        }
                    }
                }
            }

            stepCount++;

        }
     
        int ans = -1;
        int minWaittime = 0;
          int maxWaitTime = 1000000000;
        while (minWaittime <= maxWaitTime) {
            int mid = minWaittime + (maxWaitTime - minWaittime) / 2;
            if (checkHouse(grid, mid, directions)) {
                ans = mid;
                minWaittime = mid + 1;
            } else {
                maxWaitTime = mid - 1;
            }
        }
        return ans;
    }

    public boolean checkHouse(int[][] grid, int wait, int[][] directions) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queuePerson = new LinkedList<>();

        queuePerson.add(new Pair(0, 0));
        visited[0][0] = true;

        int steps = 0;

        while (!queuePerson.isEmpty()) {
            int size = queuePerson.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> personPosition = queuePerson.poll();

                int row = personPosition.getKey();
                int col = personPosition.getValue();

                int currentArrival = wait + steps;

                // current cell check, except fire-never-reaches cells are 0
                if (grid[row][col] < 0 && currentArrival >= -grid[row][col]) {
                    continue;
                }

                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                        continue;
                    if (grid[nr][nc] == 1 || grid[nr][nc] == 2)
                        continue;
                    if (visited[nr][nc])
                        continue;

                    int nextArrival = currentArrival + 1;

                    if (nr == m - 1 && nc == n - 1) {
                        // destination allows same time as fire
                        if (grid[nr][nc] == 0 || nextArrival <= -grid[nr][nc]) {
                            return true;
                        }
                    } else {
                        // normal cells need strictly before fire
                        if (grid[nr][nc] == 0 || nextArrival < -grid[nr][nc]) {
                            visited[nr][nc] = true;
                            queuePerson.add(new Pair(nr, nc));
                        }
                    }
                }
            }

            steps++;
        }

        return false;
    }
}