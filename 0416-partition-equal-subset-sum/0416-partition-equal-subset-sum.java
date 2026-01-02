// TLE Solution using backtracking 
class Solution {
    int [] nums; 
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0; 
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1 ) return false;
        sum = sum / 2 ;
        Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];
        return dfs(nums.length - 1 , sum, memo);
    }
    public boolean dfs(int n , int sum, Boolean[][] memo){
        if( sum == 0 ) return true;
        if (n == 0 || sum < 0)
            return false;
        if(memo[n][sum] != null ) return memo[n][sum];
        boolean res = dfs(n - 1, sum - nums[n - 1], memo) || dfs(n - 1 , sum, memo); 
        memo[n][sum] = res;
        return memo[n][sum];
    }
}