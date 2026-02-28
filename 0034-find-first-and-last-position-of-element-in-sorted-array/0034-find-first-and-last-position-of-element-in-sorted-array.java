
import java.lang.annotation.Target;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int [] {-1,-1};
        int left = lowerBoundSearch(nums, target); 
        int right = upperBoundSearch(nums, target);
        if(nums[left] != target) return new int[]{-1,-1};
        int [] ans = new int [] {left , right};
   return ans ;}

    int lowerBoundSearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (nums[mid] >= target) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }

    return right; 
}

    int upperBoundSearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2 ;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

    return left; 
}
}