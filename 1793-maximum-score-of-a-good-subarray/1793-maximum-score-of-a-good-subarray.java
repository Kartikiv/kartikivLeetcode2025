class Solution {
    public int maximumScore(int[] nums, int k) {
        int left = k; 
        int right = k; 
        int res = 0 ;
        int min = nums[k];
        while (left >= 0 && right < nums.length) {
            min = Math.min(min, Math.min(nums[left], nums[right]));
            res = Math.max(min * (right - left + 1) , res);
            int leftVal = left > 0 ? nums[left - 1] : 0;
            int rightVal = right < nums.length - 1 ? nums[right + 1] : 0;

            if(leftVal >= rightVal){
                left -=1;
            }else{
                right += 1;
            }

        }
    return res; }
}