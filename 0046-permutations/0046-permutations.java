class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int [] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        helper(current, used);
        return ans;
    }

    public void helper(List<Integer> current, boolean used[]){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
          
            if(!used[i]){
                current.add(nums[i]);
                used[i] = true;
                helper(current, used);
                current.remove(current.size() - 1);
                used[i] = false;
            
            }

        }
       
        
        
    }
}