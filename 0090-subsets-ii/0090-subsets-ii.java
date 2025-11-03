class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    int [] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        helper(current, 0);

    return new ArrayList<>(ans);
    }
    public void helper(List<Integer> current, int index){
        if(index >= nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        helper(current, index + 1);
        current.remove(current.size() - 1);
        helper(current, index+1);

    }
}