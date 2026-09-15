import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int totalNodes = quiet.length;
        int[] ans = new int[totalNodes];
        List<Integer>[] adjacencyList = new ArrayList[totalNodes];
        Arrays.setAll(adjacencyList, n -> new ArrayList<>());
        int[] inDegree = new int[totalNodes];
        for (int[] rich : richer) {
            int u = rich[0];
            int v = rich[1];
            inDegree[v]++;
            adjacencyList[u].add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalNodes; i++) {
            ans[i] = i;
            if (inDegree[i] == 0) {
                queue.add(i);
            
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int child : adjacencyList[node]) {
                    if (quiet[ans[node]] < quiet[ans[child]]) {
                        ans[child] = ans[node];
                    }
                    inDegree[child]--;
                    if (inDegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }

        return ans;
    }
}