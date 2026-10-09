class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<Pair<Integer, Integer>>[] adjacencyList = new List[n + 1];
        Arrays.setAll(adjacencyList, i -> new ArrayList<>());

        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            adjacencyList[source].add(new Pair<>(destination, weight));
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[k] = 0;

        // Pair = <distance, node>
        PriorityQueue<Pair<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) ->
                        Integer.compare(a.getKey(), b.getKey()));

        pq.add(new Pair<>(0, k));

        while (!pq.isEmpty()) {

            Pair<Integer, Integer> current = pq.poll();

            int currentDistance = current.getKey();
            int node = current.getValue();

            // stale entry
            if (currentDistance > distances[node]) {
                continue;
            }

            for (Pair<Integer, Integer> edge : adjacencyList[node]) {

                int child = edge.getKey();
                int weight = edge.getValue();

                int newDistance = currentDistance + weight;

                if (newDistance < distances[child]) {
                    distances[child] = newDistance;
                    pq.add(new Pair<>(newDistance, child));
                }
            }
        }

        int maxDistance = 0;

        for (int node = 1; node <= n; node++) {
            if (distances[node] == Integer.MAX_VALUE) {
                return -1;
            }

            maxDistance = Math.max(maxDistance, distances[node]);
        }

        return maxDistance;
    }
}