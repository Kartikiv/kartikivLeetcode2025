class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[k] = 0;

        // Bellman-Ford
        for (int i = 0; i < n - 1; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if (distances[u] != Integer.MAX_VALUE &&
                    distances[u] + w < distances[v]) {

                    distances[v] = distances[u] + w;
                }
            }
        }

        int totalMaxPropagationTime = 0;

        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1;
            }

            totalMaxPropagationTime =
                Math.max(totalMaxPropagationTime, distances[i]);
        }

        return totalMaxPropagationTime;
    }
}