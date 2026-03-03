import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();

        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (greedyPacking(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return right;
    }

    boolean greedyPacking(int[] weight, int capacity, int days) {
        int totalWeight = 0;
        int day = 1;
        for (int i = 0; i < weight.length; i++) {
            if (weight[i] > capacity) return false;
            totalWeight += weight[i];
            if (totalWeight > capacity) {
                totalWeight = weight[i];
                day++;
            }

        }
        return day <= days;
    }
}