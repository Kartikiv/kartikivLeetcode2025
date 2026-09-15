
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Build a reveerse directed graph add all the processed nodes
        // return the nodes in sorted order
        // the one that are in the queue and not processed are unsafe
        int[] inDegree = new int[graph.length];
        List<Integer>[] adjacencyList = new ArrayList[graph.length];
        Arrays.setAll(adjacencyList, n -> new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int node : graph[i]) {
                adjacencyList[node].add(i); // adding a reverse edge
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // process the nodes
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                inDegree[node] = -1;
                for (int child : adjacencyList[node]) {
                    inDegree[child]--;
                    if (inDegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }

        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == -1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}