class Solution {
    public int longestOnes(int[] nums, int k) {
     int maxLen = 0 ; 
     int countZero = 0 ;
     for (int j = 0 , i = 0; j < nums.length; j++) {
        if(nums[j] == 0 ) countZero++;
        while(countZero > k){
            if(nums[i] == 0 ) countZero--;
            i++;
        }
       maxLen =Math.max(maxLen, j - i + 1);

     }   

   return maxLen;  }
}