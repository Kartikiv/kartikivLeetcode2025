class Solution {
    public int shipWithinDays(int[] weights, int days) {
         int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        left--;
        while (left < right) {
            int mid = left + (right - left + 1) / 2 ;
            if(!canShip(weights,mid, days)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
    return left + 1; 
    }
    boolean canShip(int[] weights, int capacity, int days){
        int currentDays = 1; 
        int currentLoad = 0; 
        int i = 0 ; 
        while (i < weights.length) {
           currentLoad += weights[i];
           if(currentLoad > capacity){
            currentLoad = weights[i] ;
            currentDays++;
           }
           i++;
           
        }
    return currentDays <= days; 
    }
}