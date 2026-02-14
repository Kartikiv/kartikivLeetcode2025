class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

    return (slidingWindowWithAtmostK(nums, goal) - slidingWindowWithAtmostK(nums, goal - 1)); 
}

     int slidingWindowWithAtmostK(int nums[], int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int windowSum = 0 ;

        while (j < nums.length) {
            windowSum += nums[j];
            while(i <= j && windowSum > k){
                windowSum -= nums[i];
                i++;
            }
            count+= j - i + 1;
            j++;
        }
        return count;
    }
}