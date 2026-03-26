class Solution {
    public boolean validTree(int n, int[][] edges) {
        int [] nums = new int[n]; 
        Arrays.fill(nums, -1);
        for(int [] edge : edges){ 
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            if(x == y) return false;
            // union
            nums[y] = x; 
            
        }

    return edges.length == n -1;}
    public int find(int [] nums, int edge){ 
        int root, node = edge;
        while(nums[node] != -1){ 
            node = nums[node];
        }
        // found the root
        root = node;
        node = edge; 
        // path compression
        while(nums[node] != -1){
            int temp = nums[node];
            nums[node] = root;
            node = temp;
        }
    return root;}
}