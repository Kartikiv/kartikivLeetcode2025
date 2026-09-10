import java.util.*;
class Solution {
    // Here we can use kahns bfs algorithm to see if cycles exist 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int order = 0;
        // calculate indegree 
        int [] inDegree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for(int [] prerequisite : prerequisites){ 
            inDegree[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){ 
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order++;
            for(int child : graph[node]){ 
                inDegree[child]--;
                if(inDegree[child] == 0){ 
                    queue.add(child);
                }
            }
            
        }
    return order == numCourses; 
}
}