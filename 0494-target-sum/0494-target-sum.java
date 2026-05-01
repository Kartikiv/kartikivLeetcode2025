class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        return backtrack(nums, target, 0);
    }

    public int backtrack(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        } // found a path

        // backtrack choices
        int add = backtrack(nums, target - nums[index], index + 1);
        int subtract = backtrack(nums, target + nums[index], index + 1);

        return add + subtract;
    }
}