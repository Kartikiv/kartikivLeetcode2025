record Pair(int vertex, int weight) {
};

record QueueNode(int bestDistance, int vertex) {
};

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];

        int ans = Integer.MIN_VALUE;
        // Fill in all the distances with Infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        // Building Adjacency List
        Map<Integer, List<Pair>> adjacencyList = buildAdjacencyList(times, n);
       

        // Select the target or start node push it into the queue 
        distances[k] = 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(0, k));
        while (!queue.isEmpty()) {
            QueueNode qNode = queue.poll();
            List<Pair> pairs = adjacencyList.getOrDefault(qNode.vertex(), new ArrayList<Pair>());
            for (Pair pair : pairs) {
                // Relaxation is performed if we find any distances shorter than the present distances 
                if (distances[pair.vertex()] > qNode.bestDistance() + pair.weight()) {
                    distances[pair.vertex()] = qNode.bestDistance() + pair.weight();
                    queue.add(new QueueNode(distances[pair.vertex()], pair.vertex()));
                }
            }

        }

        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, distance);
        }
        return ans;
    }

    public Map<Integer, List<Pair>> buildAdjacencyList(int[][] times, int n) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int[] edge : times) {
            map.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(new Pair(edge[1], edge[2]));
        }

        return map;
    }
}