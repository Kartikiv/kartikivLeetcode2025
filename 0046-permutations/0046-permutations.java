class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int [] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        helper(current);
        return ans;
    }

    public void helper(List<Integer> current){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for(int n : nums){
          
            if(!current.contains(n)){
                current.add(n);
                helper(current);
                current.remove(current.size() - 1);
            
            }

        }
       
        
        
    }
}