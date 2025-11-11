import java.util.*;

record Node(int val, Set<Integer> children) {}

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        // build nodes
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i, new HashSet<>()));
        }
        // build undirected adjacency
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            map.get(a).children().add(b);
            map.get(b).children().add(a);
        }

        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);     // mark this whole component
                count++;    // one more component
            }
        }
        return count;
    }

    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : map.get(u).children()) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
