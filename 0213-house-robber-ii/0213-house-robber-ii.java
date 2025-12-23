class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        int firstPart [] = Arrays.copyOfRange(nums, 0, len - 1);
        int secondPart [] = Arrays.copyOfRange(nums, 1, len );

        return Math.max(rob1(firstPart), rob1(secondPart));
    }
    public int rob1(int[] nums) {
        
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);
        int dp [] = new int [len];
        int maxRob = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            maxRob = Math.max(maxRob, dp[i]);
        }
    return maxRob; 
    }
}