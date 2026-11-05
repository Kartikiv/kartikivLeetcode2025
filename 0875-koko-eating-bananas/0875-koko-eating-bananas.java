class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canEat(int[] piles, int h, int k) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += Math.ceilDiv(pile, k);
        }
        return totalTime <= h;
    }
}