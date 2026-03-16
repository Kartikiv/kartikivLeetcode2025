
import java.sql.RowId;

class Solution {
    public int search(int[] nums, int target) {
       int low = 0; 
       int high = nums.length - 1; 
       while (low <= high) {
        int mid = low + (high - low) / 2; 
        if(nums[mid] == target){
            return mid; 
        }
        // check if left half is sorted and target is in the left half
        else if(nums[mid] >= nums[low]){
            if(target >= nums[low] && target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
            // right half is sorted
        }else{
            if(target <= nums[high] && target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
       }
    return  -1; }
}