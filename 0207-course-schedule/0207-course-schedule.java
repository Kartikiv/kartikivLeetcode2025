import java.util.*;

class Solution {
    List<Integer>[] g;   // g[u] = list of prerequisites of u
    int[] state;         // 0=unvisited, 1=visiting, 2=done

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            int course = p[0], pre = p[1];
            g[course].add(pre); // follow prereqs
        }

        state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(i)) return false; // cycle found
        }
        return true; // no cycles
    }

    private boolean dfs(int u) {
        if (state[u] == 1) return false; // back-edge -> cycle
        if (state[u] == 2) return true;  // already processed

        state[u] = 1; // mark as on recursion stack
        for (int v : g[u]) {
            if (!dfs(v)) return false;
        }
        state[u] = 2; // done
        return true;
    }
}
