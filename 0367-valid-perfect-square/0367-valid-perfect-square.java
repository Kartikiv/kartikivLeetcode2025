class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1 ; 
        int high = num; 
        if(num == 0 || num == 1) return true; 
        while (low <= high) {
            int mid = high + (low - high) / 2; 
            long product = (long) mid * mid;
            if(product == num) return true; 
            if(product > num){ 
                high = mid - 1; 
            }else{ 
                low = mid + 1;
            }
        }
    return false; 
    }
}