class Solution {
    public int search(int[] nums, int target) {
        int left = searchPivot(nums);
        int right = nums.length - 1;
        int ans =binarySearch(nums, left, right, target);
    return ans == -1 ? binarySearch(nums, 0, left - 1, target): ans; 
    }
    public int binarySearch(int [] nums, int left , int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } 
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
    return -1; 
    }
    public int searchPivot(int[] nums) {
        int left = 0 ; 
        int right = nums.length - 1; 
        while(left < right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
    return left; 
    }
}