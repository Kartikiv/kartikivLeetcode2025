import java.util.*;
class Solution {
    List<List<Integer>> paths; 
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.paths = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>());
        return paths;
    }
    public void dfs(int [][] graph, int node, List<Integer> path){ 
        path.add(node); 
        if(node == graph.length - 1){ 
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // the graph given in a way such that graph[i] is the list of all the nodes that 
        // we can visit from node i
        // the graph is acylic no need to track the visited nodes 
        for(int child : graph[node]){ 
            dfs(graph, child,path); 
        }
        path.remove(path.size() - 1);

    }
}