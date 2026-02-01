class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int countZero = 0;
        int maxWindowSize = 0;
        while (j < nums.length) {
            if(nums[j] == 0) countZero++;
            while(i <= j && countZero > k){
                if(nums[i] == 0) countZero --;
                i++;
            }
            maxWindowSize = Math.max(maxWindowSize, j - i + 1);
            j++;

        }

    return maxWindowSize;
}
}