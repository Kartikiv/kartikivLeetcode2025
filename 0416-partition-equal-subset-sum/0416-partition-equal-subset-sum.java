class Solution {
    Boolean [][] memo;
    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum() ;
        if(target % 2 ==1 ){ 
            return false; 
        }
        target = target / 2;
        this.memo = new Boolean[nums.length][target + 1];
        return canPartitionSum(nums, target, 0);
    }
    public boolean canPartitionSum(int [] nums, int target, int index){ 
        if(index >= nums.length || target < 0){ 
            return false;
        }
        if(memo[index][target] != null) return memo[index][target];
        // pick or dont pick 
        if(target == 0){ 
            return true;
        }
        // pick 
        boolean pick = canPartitionSum(nums, target - nums[index], index + 1); 
        boolean dontPick = canPartitionSum(nums, target, index + 1);
        memo[index][target] = pick || dontPick;
        return memo[index][target];
    }
}