class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = new ArrayList[n];
        int result = -1;
        int minSpan = Integer.MAX_VALUE;
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph[u].add(new int[] { v, weight });
            graph[v].add(new int[] { u, weight });

        }

        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[] { i, 0 });
            distances[i] = 0;

            while (!pq.isEmpty()) {
                int node[] = pq.poll();
                int u = node[0];
                int distance = node[1];
                if (distance > distances[u])
                    continue;
                if (distance > distanceThreshold)
                    break;

                for (int[] edge : graph[u]) {
                    int v = edge[0];
                    int weight = edge[1];

                    if (distance + weight < distances[v]) {
                        distances[v] = distance + weight;
                        pq.offer(new int[] { v, distances[v] });
                    }
                }
            }
            int span = 0;
            for (int j = 0; j < distances.length; j++) {
                if(j == i) continue;
                if (distances[j] <= distanceThreshold) {
                    span++;
                }
            }

            if (span <= minSpan) {
                minSpan = span;
                result = i;
            }

        }
        return result;
    }
}