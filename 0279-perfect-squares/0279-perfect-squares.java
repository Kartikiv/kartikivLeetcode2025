
import java.util.*;

class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(n);
        visited[n] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int k = 1; k * k <= cur; k++) {
                    int next = cur - k * k;

                    if (next == 0) return steps;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return steps;
    }
}
