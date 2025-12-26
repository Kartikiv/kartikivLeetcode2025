class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLis = 1 ; 
        int dp [] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = nums.length - 1; i >= 0; i-- ){
            int num = nums[i];
            for ( int j =  i + 1 ; j < nums.length ; j++ ){
                if(num < nums[j] ){
                dp [i] =  Math.max(dp[i], 1 + dp[j]);
                
                }
                maxLis = Math.max(dp[i], maxLis);
            }
        }

    return maxLis; 
    }
}