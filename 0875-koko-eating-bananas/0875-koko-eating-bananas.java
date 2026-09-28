class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = Arrays.stream(piles).max().getAsInt();
        while(low <= high){ 
            int mid = low + (high - low) / 2;
            if(canEat(piles, mid, h)){ 
               high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    return low; 
    }

    public boolean canEat(int[] piles, int speed, int h) {
        long eattenTime = 0;
        for (int pile : piles) {
            eattenTime += Math.ceilDiv(pile, speed);
        }
    return eattenTime <= h; }
}