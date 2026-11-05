class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if(matrix[mid][0] <= target){ 
                low = mid;
            }else{ 
                high = mid - 1;
            }
        }

        int [] nums = matrix[low]; 
        low = 0; 
        high = nums.length - 1;
        while(low <= high){ 
            int mid = low + (high - low) / 2; 
            if(nums[mid] == target){ 
                return true;
            }
            if(nums[mid] > target){ 
                high = mid - 1;
            }else{ 
                low = mid + 1;
            }
        }
    return false;}
}