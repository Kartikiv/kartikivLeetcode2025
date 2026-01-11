class Solution {
    Set< List<Integer> >ans = new HashSet<>();
    int [] nums; 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);

        dfs(0, new ArrayList<>());
          
return new ArrayList<>(ans);
    }
    public void dfs(int index, List<Integer> list){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
       
            return;
        }
       
        dfs(index + 1, list);
        list.add(nums[index]);
        
        dfs(index + 1, list);
        list.remove(list.size() -1);
    }
}