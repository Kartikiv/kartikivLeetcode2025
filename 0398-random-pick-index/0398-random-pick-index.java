class Solution {
    HashMap<Integer, List<Integer>> indexMap ;
    public Solution(int[] nums) {
    this.indexMap = new HashMap<>();
    for(int i = 0; i < nums.length ; i++){
      indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
        indexMap.get(nums[i]).add(i);
    }
    }
    
    public int pick(int target) {
        List<Integer> list = indexMap.get(target);
        int randIndex = (int) (list.size() * Math.random());
        return list.get(randIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */