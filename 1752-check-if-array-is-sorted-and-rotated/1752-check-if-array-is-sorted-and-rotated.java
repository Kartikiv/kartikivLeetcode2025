class Solution {
    public boolean check(int[] nums) {
        int drops = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            

            if (nums[i] > nums[i+1]) {
                drops++;
            }

            if (drops > 1) {
                return false;
            }
        }

        return drops == 0? true: nums[nums.length - 1] <= nums[0];
    }
} 