// an insert position is the place where the upper bound number is ?? 
// is this true ?? 
// if not why ?? 

class Solution {
    public int searchInsert(int[] nums, int target) {
     int left = 0; 
     int right = nums.length - 1; 

     while (left < right){
        int mid = left + (right - left) / 2 ;
        if(nums[mid] >= target){
            right = mid;
        }else{
            left = mid + 1;
        }
     }   
    return nums[right] < target ? nums.length : right ;}
}