
import java.util.HashMap;

class Solution {
    /*
     * ==================== PROBLEM FRAMEWORK ====================
     * 1) Pattern: Sliding Window
     * 2) Inputs/Guarantees: Array of Integers, all positive
     * 3) Goal: give the maximum sum of subarray of length k and
     * also all the element in the subarray should be unique.
     * 4) Invariant: we maintain a window of length k and in that window the sum is
     * maintained
     * if window is invalid then we do not consider the sum.
     * 5) Decision Rules: if windowValid maxSum = Math.max(maxSum, windowSum)
     * 6) Why correct:
     * 7) Complexity: Time O(), Space O()
     * ============================================================
     */
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        long windowSum = 0;
        long maxSum = 0;
        HashMap<Integer, Integer> windowMap = new HashMap<>();
        while (j < k) {
            windowSum += nums[j];
            windowMap.put(nums[j], windowMap.getOrDefault(nums[j], 0) + 1);
            j++;
        }
        boolean isValidWindow = windowMap.size() == k;
        if (isValidWindow) {
            maxSum = Math.max(maxSum, windowSum);
        }
        while (j < nums.length) {
            windowSum -= nums[i];
            int freq = windowMap.getOrDefault(nums[i], 0) - 1;
            if (freq == 0) {
                windowMap.remove(nums[i]);
            } else {
                windowMap.put(nums[i], freq);
            }
            i++;

            windowSum += nums[j];
            windowMap.put(nums[j], windowMap.getOrDefault(nums[j], 0) + 1);
            j++;

            isValidWindow = windowMap.size() == k;
            if (isValidWindow) {
                maxSum = Math.max(maxSum, windowSum);
            }

        }
   return maxSum; 
 }
}