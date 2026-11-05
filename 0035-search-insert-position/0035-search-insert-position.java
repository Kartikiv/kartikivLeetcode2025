class Solution {
    public int searchInsert(int[] nums, int target) {
        // First value greater than equal to target 
        int low = 0; 
        int high = nums.length; 

        while(low < high){ 
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){ 
                high = mid;
            }else{ 
                low = mid + 1;
            }
        }
    return high; 
    }
}