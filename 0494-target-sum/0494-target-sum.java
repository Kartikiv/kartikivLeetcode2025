class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
    return backtrack(0, nums, target); 
    }
    public int backtrack(int index, int [] nums, int target){ 
        if(nums.length == index){ 
            return target == 0 ? 1 : 0; 
        }
        // here i backtrack 
        int add = backtrack(index + 1, nums, target + nums[index]); // subtract number
        int subtract = backtrack(index + 1, nums, target - nums[index]); // add number 
        
        return add + subtract; 
        }
}