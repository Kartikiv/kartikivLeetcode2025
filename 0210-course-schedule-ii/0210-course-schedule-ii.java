class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses]; 
        Arrays.setAll(adjacencyList, n -> new ArrayList<>());
        int [] order = new int [numCourses];
        int [] inDegree = new int [numCourses];
        int orderIndex = 0;
        for(int [] prerequisite: prerequisites){ 
            int prerequisiteCourse = prerequisite[1];
            int course = prerequisite[0]; 
            inDegree[course]++;
            adjacencyList[prerequisiteCourse].add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                order[orderIndex++] = node;
                for(int child : adjacencyList[node]){
                    inDegree[child]--; 
                    if(inDegree[child] == 0){
                        queue.add(child);
                    }
                }
            }
        }
    return orderIndex == order.length ? order : new int []{}; 
    }
}