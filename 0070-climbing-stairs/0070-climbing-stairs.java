class Solution {
    public int climbStairs(int n) {
        // We need to develop a recursive relationship between nth stair 
        if(n < 1) return 0;
        int [] dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;  
        for(int i =2 ; i < dp.length ; i++){ 
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[dp.length -1];
    }
}