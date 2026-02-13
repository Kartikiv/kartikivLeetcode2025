class Solution {
    /*
     * ==================== PROBLEM FRAMEWORK ====================
     * 1) Pattern:Sliding Window
     * 2) Inputs/Guarantees: given a target and an array
     * 3) Goal: length of minimum subarray with sum == target
     * 4) Invariant: take a window and keep add till the sum is less than equal to
     * target
     * if sum is greater than target move the window right
     * 5) Decision Rules: if(sum > target ) left ++;
     * 6) Why correct:
     * 7) Complexity: Time O(), Space O()
     * ============================================================
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minWindowLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                minWindowLen = Math.min(minWindowLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minWindowLen == Integer.MAX_VALUE ? 0 : minWindowLen;
    }
}