import java.util.*;

public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        Arrays.sort(nums);
        reverse(nums);

        if (nums[0] > target) {
            return false;
        }

        int n = nums.length;
        Boolean[] memo = new Boolean[1 << n];

        return dfs(nums, 0, 0, target, memo);
    }

    private boolean dfs(int[] nums, int mask, int currSum, int target, Boolean[] memo) {
        if (mask == (1 << nums.length) - 1) {
            return currSum == 0;
        }

        if (memo[mask] != null) {
            return memo[mask];
        }

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue; // already used
            }

            if (currSum + nums[i] > target) {
                continue;
            }

            int nextSum = (currSum + nums[i]) % target;
            int nextMask = mask | (1 << i);

            if (dfs(nums, nextMask, nextSum, target, memo)) {
                memo[mask] = true;
                return true;
            }

            // pruning:
            // if current bucket is empty and this number doesn't work,
            // trying another same-sized failure pattern is often redundant
            if (currSum == 0) {
                break;
            }

            // skip duplicates
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        memo[mask] = false;
        return false;
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}