class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 ;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2 ; 
            // search left  
            if(canEat(piles, mid, h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
    return right; 
    }
    boolean canEat(int [] piles ,int currentSpeed, int h){
        int timeConsumed = 0 ;
        for (int pile : piles){
            timeConsumed += Math.ceilDiv(pile, currentSpeed);
        }
        return timeConsumed <= h; 
    }
}