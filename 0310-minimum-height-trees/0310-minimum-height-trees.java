class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> minimumNode = new ArrayList<>();
        int numNodes = edges.length + 1;
        if(numNodes == 1){ 
            return Arrays.asList(0);
        }
        
        if(numNodes == 2){ 
            return Arrays.asList(0, 1);
        }

        List<List<Integer>> adjacencyList = new ArrayList<>(numNodes);
        for(int i = 0 ; i < numNodes; i++){ 
            adjacencyList.add(new ArrayList<>());
        }
        int[] degree = new int[numNodes];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adjacencyList.get(u) == null) {
                adjacencyList.add(u, new ArrayList<>());
            }
            if (adjacencyList.get(v) == null) {
                adjacencyList.add(v, new ArrayList<>());
            }
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        int remainingNodes = numNodes;
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int child : adjacencyList.get(node)) {
                    degree[child]--;
                    if(degree[child] == 1){
                        queue.add(child);
                    }
                }
            }

        }
        while (!queue.isEmpty()) {
            minimumNode.add(queue.poll());
        }

        return minimumNode;
    }
}
