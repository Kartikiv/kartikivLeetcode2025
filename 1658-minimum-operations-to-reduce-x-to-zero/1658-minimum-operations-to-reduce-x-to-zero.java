
    /*
     * ==================== PROBLEM FRAMEWORK ====================
     *
     * At first glance, this problem feels like:
     * → Two choices (remove from left or right)
     * → Sounds like backtracking → optimize to DP
     *
     * But that path is a trap.
     *
     * Key Insight: Reverse the thinking.
     *
     * Instead of asking:
     * "Which elements should I remove to reach sum x?"
     *
     * Ask:
     * "Which subarray should I KEEP so that the removed sum = x?"
     *
     * ------------------------------------------------------------
     * Example:
     * nums = [1,1,4,2,3], x = 5
     *
     * Total sum = 11
     * If we remove elements summing to x = 5,
     * the remaining subarray must sum to:
     *
     * target = totalSum - x = 11 - 5 = 6
     *
     * So the problem becomes:
     * Find the LONGEST subarray with sum = target
     *
     * Why longest?
     * Because we want to remove the FEWEST elements.
     *
     * operations = n - length_of_longest_subarray
     *
     * ------------------------------------------------------------
     * Pattern:
     * Sliding Window with reverse thinking
     *
     * ------------------------------------------------------------
     * Inputs / Guarantees
     * - Positive integers → sliding window works
     * - Remove only from left or right
     *
     * ------------------------------------------------------------
     * Goal
     * Find the minimum number of operations to reduce x to zero.
     *
     * Equivalent goal:
     * Find the longest subarray with sum = totalSum - x.
     *
     * ------------------------------------------------------------
     * Invariant (Sliding Window)
     * Maintain a window [i, j] such that:
     * windowSum <= target
     *
     * If windowSum > target → shrink from left.
     * If windowSum == target → update max length.
     *
     * ------------------------------------------------------------
     * Decision Rules
     * Expand window → add nums[j]
     * While windowSum > target → move i++
     * If windowSum == target → record length
     *
     * ------------------------------------------------------------
     * Why This is Correct
     * Removing elements from ends is equivalent to
     * keeping one contiguous middle subarray.
     *
     * Maximizing the kept subarray minimizes removals.
     *
     * ------------------------------------------------------------
     * Complexity
     * Time : O(n)
     * Space : O(1)
     *
     * ============================================================
     */
   class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int v : nums) totalSum += v;
       // System.out.println(totalSum);
        int target = totalSum - x;
        if (target < 0) return -1;
        if (target == 0) return nums.length;

        int maxLen = slidingWindow(nums, target);
        return maxLen == 0 ? -1 : nums.length - maxLen;
    }

    int slidingWindow(int[] nums, int target) {
        int i = 0, sum = 0, maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (i <= j && sum > target) {
                sum -= nums[i++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
