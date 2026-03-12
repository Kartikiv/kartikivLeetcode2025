import java.util.*;
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer> [] adjacencyList = new ArrayList[n];
        int [] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int [] edge : edges){
            int node = edge[0];
            adjacencyList[node].add(edge[1]);
            adjacencyList[edge[1]].add(node);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neighbours = adjacencyList[node];
            for(int neighbour : neighbours){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    if(parent[neighbour] == -1 ) parent[neighbour] = node;
                    queue.add(neighbour);
                  
                }else{
                    if(neighbour != parent[node]) return false;
                }


            }

        }
        for(boolean node : visited){
            if(!node) return false;

        }


        return true; }
}