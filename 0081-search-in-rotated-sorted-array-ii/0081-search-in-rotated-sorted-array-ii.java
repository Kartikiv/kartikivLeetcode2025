class Solution {
    public boolean search(int[] nums, int target) {
        int left  = 0 ; 
        int right = nums.length - 1; 
        while (left <= right) {
            int mid = right + (left - right) / 2 ; 
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            // check if left half is sorted
            }else if(nums[mid] >= nums[left]){
                // check if the target is present in the left half
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1; 
                }
                // or go to the right unsorted part
                else{
                    left = mid + 1; 
                }
            // right half is sorted
            }else{
                // check if the target is present in the right sorted part
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                // or go the left unsorted part
                else{
                    right = mid - 1;
                }
            }
        }
    return false; }
}