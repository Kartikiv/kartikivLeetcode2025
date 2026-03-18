class Solution {
    public int longestOnes(int[] nums, int k) {
        // Step 1 : expand the window till there are atmost 2 zeros in the window 
        int i = 0; 
        int j = 0; 
        int numZero = 0 ; 
        int maxWindow = 0 ;
        while (j < nums.length) {
            // expand the window
            if(nums[j] == 0) numZero++;
            if (i <= j && numZero > k) {
                if(nums[i] == 0) numZero--;
                i++;
            }
            // check after window become valid and store max
            maxWindow = Math.max(maxWindow, j - i + 1);
            j++;
        }
  return maxWindow; 
  }
}