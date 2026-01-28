
import java.util.HashMap;

/**
 * Finds the number of contiguous subarrays whose elements sum to a target value.
 * 
 * @param nums an array of integers that may contain positive, negative, or zero values
 * @param k the target sum to find in subarrays
 * @return the count of contiguous subarrays that sum to k
 * 
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(n) for the HashMap storing prefix sums
 * 
 * Algorithm: Uses a prefix sum approach with a HashMap to store the frequency of
 * cumulative sums. For each element, it checks if (currentSum - k) exists in the map,
 * which indicates a subarray ending at the current position with sum k.
 */
class Solution {
    
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> preMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        // this  indicate an empty subarray with sum = 0
        preMap.put(0,1);
        for(int num : nums){
            sum+=num;
            ans += preMap.getOrDefault(sum - k, 0);
            preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
        }
    return  ans;}
}