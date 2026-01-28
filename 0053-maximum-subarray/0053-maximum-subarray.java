/**
 * Finds the contiguous subarray with the maximum sum.
 * 
 * This method implements a variant of Kadane's algorithm to find the maximum sum
 * of a contiguous subarray within the given array of integers.
 * 
 * @param nums an array of integers which may contain positive, negative, or zero values
 * @return the maximum sum of any contiguous subarray; returns Integer.MIN_VALUE if the array is empty
 * 
 * @example
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6 (subarray [4, -1, 2, 1])
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum < 0) {
                max = Math.max(sum, max);
                sum = 0;
                continue;
            }
            max = Math.max(sum, max);
        }
    return max;
}
}