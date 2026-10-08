class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];
        Arrays.setAll(adjacencyList, n -> new ArrayList<>());
        // Bfs with inDegree 
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            inDegree[u]++;
            adjacencyList[v].add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int processedNodes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            processedNodes += size;
            for(int i = 0; i < size; i++){ 
                int node = queue.poll();

                for(int child : adjacencyList[node]){ 
                    inDegree[child]--;
                    if(inDegree[child] == 0){ 
                        queue.add(child);
                    }
                }
            }
        }
    return processedNodes == numCourses; 
    }
}