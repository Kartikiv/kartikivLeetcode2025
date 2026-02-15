class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int sum = 0;
        while (j < nums.length) {
            if (nums[j] == 0) sum += 1;
            while (sum > 1) {
                if (nums[i] == 0) sum -= 1;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen - 1;
    }

}