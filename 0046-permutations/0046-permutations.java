class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        List<Integer> included = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, 0, visited, included);
        return ans;
    }

    public void backTrack(int[] nums, int index, boolean[] visited, List<Integer> included) {
        if (index == nums.length) {
            if (included.size() == nums.length) {
                ans.addLast(new ArrayList<>(included));
                return;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            included.add(nums[i]);
            visited[i] = true;

            backTrack(nums, index + 1, visited, included);

            included.remove(included.size() - 1);
            visited[i] = false;
            
        }

    }
}