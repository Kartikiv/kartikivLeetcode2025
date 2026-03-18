class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] - nums[i] == prefix[nums.length - 1] - prefix[i]) {
                return i;
            }
        }
        return -1;
    }
}