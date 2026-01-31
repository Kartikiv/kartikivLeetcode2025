import java.util.*;

/**
 * Checks if there exists a continuous subarray of length at least 2 whose elements sum to a multiple of k.
 * 
 * Uses a HashMap to store the first occurrence of each remainder when the cumulative sum is divided by k.
 * If the same remainder is encountered again and the distance between indices is at least 2,
 * it means a subarray with sum divisible by k has been found.
 * 
 * @param nums the input array of integers
 * @param k the divisor to check if subarray sum is a multiple of k
 * @return true if a subarray of length at least 2 with sum divisible by k exists, false otherwise
 * 
 * @time O(n) where n is the length of the input array
 * @space O(min(n, k)) for the HashMap storing remainders
 */
class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1); // handles subarrays starting at index 0

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;

            if (remainderIndex.containsKey(rem)) {
                if (i - remainderIndex.get(rem) >= 2) {
                    return true;
                }
            } else {
                remainderIndex.put(rem, i); // store first occurrence only
            }
        }
        return false;
    }
}
