class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
