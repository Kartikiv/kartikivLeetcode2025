class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
                i = j;
            }
            if (j >= nums.length) {
                break;
            }
                maxOnes = Math.max(maxOnes, j - i + 1);
            j++;
        }
        return maxOnes;
    }
}