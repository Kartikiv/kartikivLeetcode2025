import java.util.HashMap;

class Solution {

    /**
     * Finds the number of contiguous subarrays whose elements sum to a given target
     * value.
     * 
     * Uses a prefix sum approach with a HashMap to efficiently count subarrays.
     * For each element, checks if there exists a previous prefix sum such that
     * (current prefix sum - previous prefix sum) equals the target value k.
     * 
     * Time Complexity: O(n) where n is the length of the input array
     * Space Complexity: O(n) for the HashMap storing prefix sums
     * 
     * @param nums the input array of integers
     * @param k    the target sum to find in subarrays
     * @return the count of contiguous subarrays that sum to k
     */
    public int subarraySum(int[] nums, int k) { 
        HashMap<Integer, Integer> preFixMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        // Empty subarraySum = 0
        preFixMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += preFixMap.getOrDefault(sum - k, 0);
            preFixMap.put(sum, preFixMap.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }
}