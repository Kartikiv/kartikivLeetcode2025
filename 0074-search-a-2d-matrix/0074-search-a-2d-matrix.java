class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int [] mat = matrix[searchLowerBound(matrix,target)];
        return searchArray(mat, target);
    }

    boolean searchArray(int [] matrix, int target){
        int left = 0; 
        int right = matrix.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid] == target){
                return true;
            }
            if(matrix[mid] < target){
                left = mid + 1;
            } else{
                right = mid -1 ;
            }
        
        }
        return false; 
    }
    int searchLowerBound(int [][] matrix, int target){
        int left = 0; 
        int right = matrix.length - 1;
        while(left < right){
                int mid = left + (right - left + 1) / 2;
            if(matrix[mid][0] <= target){
                left = mid;
            } else{
                right = mid - 1;
            }
        
        }
        return left; 
    }
}