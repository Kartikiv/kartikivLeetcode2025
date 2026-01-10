// 
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int [cost.length + 1] ;
         dp [0] = cost[0];
         dp [1] = cost[1];
         for(int i = 2; i < dp.length; i++ ){
            int price = i < cost.length ? cost[i] : 0; 
            dp[i] = Math.min(dp[i - 1] + price,dp[i - 2] + price);
         }
    return dp[cost.length];
    }
}