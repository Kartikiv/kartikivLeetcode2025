import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) { 
            int mid = left + (right - left) / 2; 
            if(canEat(piles, mid,h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
    return right;
}

    public boolean canEat(int [] piles, int h, int maxTime){
        int time = 0;
        for (int pile : piles){
            time += (int) Math.ceil((double) pile / h);
            if(time > maxTime) return false;
        }
    return true; 
}
}