class Solution {
    public int mySqrt(int x) {
        long low  = 1; 
        long high = x; 
        while (low < high) {
            long mid = low + (high - low) / 2 + 1;
            if(mid * mid <= x){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
    return (int) high ; 
    }
}