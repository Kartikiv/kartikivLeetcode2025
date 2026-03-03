import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();     // at least the heaviest package
        int right = Arrays.stream(weights).sum();               // at most ship all in one day

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, days)) {
                right = mid;            // mid works, try smaller
            } else {
                left = mid + 1;         // mid doesn't work, need bigger
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int day = 1;
        int load = 0;

        for (int w : weights) {
            load += w;
            if (load > capacity) {      // start new day
                day++;
                load = w;
                if (day > days) return false; // early exit
            }
        }
        return true;
    }
}