class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum < 0) {
                max = Math.max(sum, max);
                sum = 0;
                continue;
            }
            max = Math.max(sum, max);
        }
    return max;
}
}