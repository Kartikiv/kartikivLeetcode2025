class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// Clasic Dp 
// the way we can reach the nth step is by either reaching n-1 th step or n - 2 step 
// Therefore the total no of ways of reach is the sum of the ways of reach n - 1 and n - 2
// Simple idea
// Direct tablulation 
