class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2 ;
            if(canShip(weights,mid, days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
    return right; 
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