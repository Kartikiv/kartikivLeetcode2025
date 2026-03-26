class Solution {
    int target;
    int[] nums;

    // Brute force 
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int total = Arrays.stream(nums).sum();
        if (total % k != 0)
            return false;
        this.target =total / k;
        return dfs(0, new boolean[nums.length], target, k);
    }

    public boolean dfs(int i, boolean[] used, int sum, int k) {
        if (k == 0) {
            return true;
        }
        if (sum == 0) {
            return dfs(0, used, target, k - 1);
        }
        // enter the dfs
        for (int j = i; j < nums.length; j++) {
            if (used[j] || sum - nums[j] < 0) {
                continue;
            }
            used[j] = true;
            if (dfs(j, used, sum - nums[j], k)) {
                return true;
            }
            used[j] = false;
        }

        return false;
    }
}